package com.gdg.IriON.entity.adopt;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Adoptions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AdoptEntity {

    @Id @GeneratedValue
    private Long id;

    private String content;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Column(name = "adopt_date")
    private LocalDateTime adoptDate;

    @Column(name = "is_adopted")
    private Boolean isAdopted;

    private String rejection;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @JoinColumn(name = "animal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnimalEntity animalEntity;
}
