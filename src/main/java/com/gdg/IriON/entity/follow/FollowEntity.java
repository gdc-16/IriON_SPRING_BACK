package com.gdg.IriON.entity.follow;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
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

    private Boolean follow;

    @Builder
    public FollowEntity(Long id, UserEntity userEntity, AnimalEntity animalEntity, Boolean follow) {
        this.id = id;
        this.userEntity = userEntity;
        this.animalEntity = animalEntity;
        this.follow = follow;
    }

    public void changeFollow() {
        this.follow = false;
    }
}
