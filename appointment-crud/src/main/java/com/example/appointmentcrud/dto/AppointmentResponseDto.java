package com.example.appointmentcrud.dto;

public class AppointmentResponseDto {
    private Long id;
    private String subject;
    private String attendee;
    private String type;

    public AppointmentResponseDto() {}

    public AppointmentResponseDto(Long id, String subject, String attendee, String type) {
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
