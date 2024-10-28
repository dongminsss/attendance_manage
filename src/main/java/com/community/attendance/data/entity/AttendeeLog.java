package com.community.attendance.data.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendee_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class AttendeeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendee_log_id")
    private Long id;

    @Column(name = "attendee_log_time", nullable = false)
    private LocalDateTime logTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;


}
