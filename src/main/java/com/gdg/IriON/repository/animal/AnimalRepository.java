package com.gdg.IriON.repository.animal;

import com.gdg.IriON.entity.animal.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
