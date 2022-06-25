package com.gdg.IriON.entity.animal;

import com.gdg.IriON.entity.shelter.ShelterEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Animals")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AnimalEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private AnimalType type;

    @Column(name = "started_date")
    private LocalDateTime startDate;

    @JoinColumn(name = "shelter_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ShelterEntity shelterEntity;
}
