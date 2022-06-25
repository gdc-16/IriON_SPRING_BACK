package com.gdg.IriON.entity.date;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Datings")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class DateEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    private String content;

    private String rejection;

    @Column(name = "is_dated")
    private Boolean isDated;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @JoinColumn(name = "animal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnimalEntity animalEntity;

    @Builder
    public DateEntity(Long id, LocalDateTime requestDate, String content, String rejection, Boolean isDated, UserEntity userEntity, AnimalEntity animalEntity) {
        this.id = id;
        this.requestDate = requestDate;
        this.content = content;
        this.rejection = rejection;
        this.isDated = isDated;
        this.userEntity = userEntity;
        this.animalEntity = animalEntity;
    }
}
