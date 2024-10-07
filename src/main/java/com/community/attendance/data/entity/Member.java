package com.community.attendance.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_m_id", nullable = false, unique = true)
    private String memberId;

    @Column(name = "member_pw", nullable = false)
    private String password;

    @Column(name = "member_nickname", nullable = false)
    private String nickName;

    @Column(name = "member_join_dates")
    private LocalDateTime joinDate;

    @Builder
    protected Member(String memberId, String password, String nickName, LocalDateTime joinDate) {
        this.memberId = memberId;
        this.password = password;
        this.nickName = nickName;
        this.joinDate = LocalDateTime.now();
    }
}
