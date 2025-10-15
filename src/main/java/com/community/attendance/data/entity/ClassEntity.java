package com.community.attendance.data.entity;

import com.community.attendance.data.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "class")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ClassEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id",unique = true, nullable = false)
    private Long id;

    @Column(name = "class_name", nullable = false)
    private String name;

    @Column(name = "class_description", length = 100)
    private String description;

}
