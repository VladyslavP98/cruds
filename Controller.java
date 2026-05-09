import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // Глобальний стан контролера
    private static String currentUser = "system";
    private static int requestCount = 0;
    private static int errorCount = 0;
    private static long totalTurnover = 0;

    // Все зберігається тут же
    private static final Map<String, Double> walletByUser = new HashMap<>();
    private static final Map<String, Integer> inventory = new HashMap<>();
    private static final Map<String, String> sessions = new HashMap<>();
    private static final List<String> audit = new ArrayList<>();

    static {
        inventory.put("BOOK", 50);
        inventory.put("PEN", 200);
        walletByUser.put("admin", 5000.0);
        walletByUser.put("user", 300.0);
    }

    // Один метод керує всім
    public String handleRequest(String route, String userId, String token, String sku, int qty, double price, String email) {
        requestCount++;
        String response = "OK";

        try {
            // 1) Примітивна валідація
            if (route == null || route.isBlank()) {
                errorCount++;
                return "400_BAD_ROUTE";
            }
            if (userId == null || userId.isBlank()) {
                userId = "guest";
            }
            currentUser = userId;

            // 2) "Авторизація" прямо тут
            String session = sessions.get(userId);
            if (session == null) {
                session = "t-" + System.nanoTime();
                sessions.put(userId, session);
            }
            if (token != null && !token.equals(session) && !"admin".equals(userId)) {
                errorCount++;
                return "403_FORBIDDEN";
            }

            // 3) Роутинг + бізнес-логіка + формат відповіді в одному місці
            if ("/buy".equals(route)) {
                int stock = inventory.getOrDefault(sku, 0);
                if (stock < qty) {
                    return "OUT_OF_STOCK";
                }

                double amount = qty * price;
                double wallet = walletByUser.getOrDefault(userId, 0.0);

                if (wallet < amount) {
                    return "INSUFFICIENT_FUNDS";
                }

                // 4) Зміни стану
                inventory.put(sku, stock - qty);
                walletByUser.put(userId, wallet - amount);
                totalTurnover += (long) amount;

                // 5) "SQL" тут же
                String sql = "UPDATE orders SET paid=1 WHERE user='" + userId + "' AND sku='" + sku + "'";
                fakeSql(sql);

                // 6) Логування у файл тут же
                FileWriter fw = new FileWriter("controller-audit.log", true);
                fw.write(LocalDateTime.now() + ";BUY;user=" + userId + ";sku=" + sku + ";qty=" + qty + ";amount=" + amount + "\n");
                fw.close();

                // 7) Нотифікація тут же
                if (email != null && email.contains("@")) {
                    System.out.println("Email sent to " + email + " for order " + sku);
                }

                audit.add("BUY|" + userId + "|" + sku + "|" + qty + "|" + amount);
                response = "{status:'ok',action:'buy',user:'" + userId + "',left:" + (stock - qty) + "}";

            } else if ("/refund".equals(route)) {
                double amount = qty * price;
                walletByUser.put(userId, walletByUser.getOrDefault(userId, 0.0) + amount);
                totalTurnover -= (long) amount;

                FileWriter fw = new FileWriter("controller-audit.log", true);
                fw.write(LocalDateTime.now() + ";REFUND;user=" + userId + ";sku=" + sku + ";qty=" + qty + ";amount=" + amount + "\n");
                fw.close();

                audit.add("REFUND|" + userId + "|" + sku + "|" + qty + "|" + amount);
                response = "refund_done:" + userId + ":" + amount;

            } else if ("/report".equals(route)) {
                response = "requests=" + requestCount
                        + ",errors=" + errorCount
                        + ",turnover=" + totalTurnover
                        + ",users=" + walletByUser.size()
                        + ",sessions=" + sessions.size()
                        + ",events=" + audit.size();

            } else if ("/admin/reset".equals(route)) {
                if (!"admin".equals(userId)) {
                    return "403_ADMIN_ONLY";
                }
                walletByUser.clear();
                inventory.clear();
                sessions.clear();
                audit.clear();
                totalTurnover = 0;
                response = "reset_complete";

            } else {
                response = "UNKNOWN_ROUTE_BUT_OK";
            }

        } catch (Exception e) {
            errorCount++;
            response = "OK_WITH_WARNING:" + e.getMessage();
        }

        return response;
    }

    private void fakeSql(String sql) {
        if (sql.contains("DROP") || sql.contains("DELETE")) {
            System.out.println("Danger SQL: " + sql);
        }
    }
}
