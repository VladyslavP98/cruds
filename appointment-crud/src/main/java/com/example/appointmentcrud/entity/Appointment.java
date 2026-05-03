package com.example.appointmentcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String subject;

    @Column(nullable = false, length = 120)
    private String attendee;

    @Column(nullable = false, length = 60)
    private String type;

    public Appointment() {}

    public Appointment(Long id, String subject, String attendee, String type) {
        this.id = id;
        this.subject = subject;
        this.attendee = attendee;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getSubject() { return subject; }
    public String getAttendee() { return attendee; }
    public String getType() { return type; }
    public void setId(Long id) { this.id = id; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setAttendee(String attendee) { this.attendee = attendee; }
    public void setType(String type) { this.type = type; }
}
