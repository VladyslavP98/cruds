package com.example.meetingcrud.dto;

public class MeetingResponseDto {
    private Long id;
    private String topic;
    private String organizer;
    private String format;

    public MeetingResponseDto() {}

    public MeetingResponseDto(Long id, String topic, String organizer, String format) {
        this.id = id;
        this.topic = topic;
        this.organizer = organizer;
        this.format = format;
    }

    public Long getId() { return id; }
    public String getTopic() { return topic; }
    public String getOrganizer() { return organizer; }
    public String getFormat() { return format; }
    public void setId(Long id) { this.id = id; }
    public void setTopic(String topic) { this.topic = topic; }
    public void setOrganizer(String organizer) { this.organizer = organizer; }
    public void setFormat(String format) { this.format = format; }
}
