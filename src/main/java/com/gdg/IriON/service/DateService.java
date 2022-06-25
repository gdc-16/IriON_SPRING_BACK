package com.gdg.IriON.service;

import com.gdg.IriON.dto.DateRequestDto;
import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.date.DateEntity;
import com.gdg.IriON.entity.user.UserEntity;
import com.gdg.IriON.repository.animal.AnimalRepository;
import com.gdg.IriON.repository.date.DateRepository;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class DateService {

    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final DateRepository dateRepository;

    public void dateInquiry(DateRequestDto dateRequestDto) {
        Optional<AnimalEntity> optionalAnimal = animalRepository.findById(dateRequestDto.getAnimalId());

        if (optionalAnimal.isEmpty()) {
            throw new RuntimeException("찾는 동물이 엄서용");
        }
        final AnimalEntity animalEntity = optionalAnimal.get();

        Optional<UserEntity> optionalUser = userRepository.findById(dateRequestDto.getUserId());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("데이트 신청 유저가 엄서용");
        }

        final UserEntity userEntity = optionalUser.get();

        dateRepository.save(
                DateEntity.builder()
                        .requestDate(LocalDateTime.now())
                        .content(dateRequestDto.getContent())
                        .rejection(null)
                        .isDated(false)
                        .userEntity(userEntity)
                        .animalEntity(animalEntity)
                        .build()
        );


    }
}
