package com.gdg.IriON.repository.follow;

import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.follow.FollowEntity;
import com.gdg.IriON.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<FollowEntity, Long> {
    Optional<FollowEntity> findByUserEntityAndAnimalEntity(UserEntity userEntity, AnimalEntity animalEntity);
    long countByAnimalEntityAndFollowIsTrue(AnimalEntity animalEntity);
}
