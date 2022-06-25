package com.gdg.IriON.entity.shelter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "Shelters")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ShelterEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @Column(name = "phone_number")
    private String phoneNumber;
}
