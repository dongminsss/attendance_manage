package com.community.attendance.data.entity;

import com.community.attendance.data.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.security.Identity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendee")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString
public class Attendee extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendee_id")
    private Long id;

    @Column(name = "attendee_name", nullable = false)
    private String name;

    @Column(name = "attendee_gender", nullable = false)
    private char gender;

    @Column(name = "attendee_birthday")
    private LocalDate birthday;

    @Column(name = "attendee_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;

}
