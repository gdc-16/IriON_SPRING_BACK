package com.gdg.IriON.entity.follow;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "Follows")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FollowEntity {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @JoinColumn(name = "animal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnimalEntity animalEntity;

    private int follow;
}
