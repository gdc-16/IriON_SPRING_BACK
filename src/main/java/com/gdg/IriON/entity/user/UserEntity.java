package com.gdg.IriON.entity.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "Users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String userId;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Boolean certificate;

    @Builder
    public UserEntity(Long id, String name, String userId, String password, UserRole role, String phoneNumber, Boolean certificate) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.certificate = certificate;
    }

    public void passQuiz() {
        this.certificate = true;
    }
}
