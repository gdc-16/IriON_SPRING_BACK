package com.gdg.IriON.repository.adopt;

import com.gdg.IriON.entity.adopt.AdoptEntity;
import com.gdg.IriON.entity.animal.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdoptRepository extends JpaRepository<AdoptEntity, Long> {
    Optional<AdoptEntity> findByAnimalEntity(AnimalEntity animalEntity);
}
