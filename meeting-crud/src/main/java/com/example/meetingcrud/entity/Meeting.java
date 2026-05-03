package com.example.meetingcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String topic;

    @Column(nullable = false, length = 120)
    private String organizer;

    @Column(nullable = false, length = 60)
    private String format;

    public Meeting() {}

    public Meeting(Long id, String topic, String organizer, String format) {
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
