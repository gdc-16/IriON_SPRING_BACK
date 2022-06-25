package com.gdg.IriON.entity.date;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import lombok.AccessLevel;
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

}
