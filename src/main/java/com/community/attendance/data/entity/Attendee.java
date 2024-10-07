package com.community.attendance.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendee")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Attendee {

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

    @Column(name = "attendee_registration")
    private LocalDateTime registrationDate;

    @Column(name = "attendee_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;

    @Builder
    protected Attendee(String name, char gender, LocalDate birthday, String description, ClassEntity classEntity) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.registrationDate = LocalDateTime.now();
        this.description = description;
        this.classEntity = classEntity;
    }
}
