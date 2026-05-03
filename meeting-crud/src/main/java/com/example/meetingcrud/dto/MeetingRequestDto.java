package com.example.meetingcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MeetingRequestDto {
    @NotBlank
    @Size(max = 120)
    private String topic;

    @NotBlank
    @Size(max = 120)
    private String organizer;

    @NotBlank
    @Size(max = 60)
    private String format;

    public MeetingRequestDto() {}

    public String getTopic() { return topic; }
    public String getOrganizer() { return organizer; }
    public String getFormat() { return format; }
    public void setTopic(String topic) { this.topic = topic; }
    public void setOrganizer(String organizer) { this.organizer = organizer; }
    public void setFormat(String format) { this.format = format; }
}
