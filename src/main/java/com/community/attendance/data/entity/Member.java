package com.community.attendance.data.entity;

import com.community.attendance.data.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@ToString(exclude = "password")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_m_id", nullable = false, unique = true, length = 20)
    private String memberId;

    @Getter(AccessLevel.NONE)
    @Column(name = "member_pw", nullable = false, length = 100)
    private String passwordHash;

    @Column(name = "member_nickname", nullable = false, length = 10)
    private String nickName;


    public boolean matchesRawPassword(PasswordEncoder encoder, String rawPassword) {
        return encoder.matches(rawPassword, this.passwordHash);
    }
}
