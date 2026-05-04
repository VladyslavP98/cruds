package com.example.coursecrud.exception;

import java.time.Instant;
import java.util.List;

public class ApiError {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private List<String> details;

    public ApiError() {}

    public ApiError(Instant timestamp, int status, String error, String message, List<String> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.details = details;
    }
}
