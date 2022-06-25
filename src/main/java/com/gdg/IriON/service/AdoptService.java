package com.gdg.IriON.service;

import com.gdg.IriON.dto.AdoptRequestDto;
import com.gdg.IriON.entity.adopt.AdoptEntity;
import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.user.UserEntity;
import com.gdg.IriON.repository.adopt.AdoptRepository;
import com.gdg.IriON.repository.animal.AnimalRepository;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdoptService {

    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    private final AdoptRepository adoptRepository;

    //false는 이미 입양된 아가들 선택했을 경우
    public boolean adoptInquiry(AdoptRequestDto adoptRequestDto) {
        Optional<AnimalEntity> optionalAnimal = animalRepository.findById(adoptRequestDto.getAnimalId());
        if (optionalAnimal.isEmpty()) {
            throw new RuntimeException("찾는 동물이 엄서용");
        }
        final AnimalEntity animalEntity = optionalAnimal.get();
        Optional<AdoptEntity> optionalAdopt = adoptRepository.findByAnimalEntity(animalEntity);
        if (optionalAdopt.isPresent()) {
            AdoptEntity adoptEntity = optionalAdopt.get();
            if (adoptEntity.getIsAdopted()) {
                return false;
            }
        }

        Optional<UserEntity> optionalUser = userRepository.findById(adoptRequestDto.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("입양신청 유저 정보가 엄서용");
        }


        final UserEntity userEntity = optionalUser.get();
        adoptRepository.save(
                AdoptEntity.builder()
                        .content(adoptRequestDto.getContent())
                        .requestDate(LocalDateTime.now())
                        .adoptDate(null)
                        .isAdopted(false)
                        .rejection(null)
                        .userEntity(userEntity)
                        .animalEntity(animalEntity)
                        .build()
        );
        return true;
    }
}
