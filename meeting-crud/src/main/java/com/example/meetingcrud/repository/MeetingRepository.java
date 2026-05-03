package com.example.meetingcrud.repository;

import com.example.meetingcrud.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
