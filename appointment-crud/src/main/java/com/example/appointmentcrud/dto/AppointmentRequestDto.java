package com.example.appointmentcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AppointmentRequestDto {
    @NotBlank
    @Size(max = 120)
    private String subject;

    @NotBlank
    @Size(max = 120)
    private String attendee;

    @NotBlank
    @Size(max = 60)
    private String type;

    public AppointmentRequestDto() {}

    public String getSubject() { return subject; }
    public String getAttendee() { return attendee; }
    public String getType() { return type; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setAttendee(String attendee) { this.attendee = attendee; }
    public void setType(String type) { this.type = type; }
}
