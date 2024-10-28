package com.community.attendance.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id",unique = true, nullable = false)
    private Long id;

    @Column(name = "class_name", nullable = false)
    private String name;

    @Column(name = "class_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    protected ClassEntity(String name, String description, Member member) {
        this.name = name;
        this.description = description;
        this.member = member;
    }
}
