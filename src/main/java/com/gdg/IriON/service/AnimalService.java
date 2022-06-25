package com.gdg.IriON.service;

import com.gdg.IriON.dto.FollowCancelRequestDto;
import com.gdg.IriON.dto.FollowRequestDto;
import com.gdg.IriON.entity.animal.AnimalEntity;
import com.gdg.IriON.entity.follow.FollowEntity;
import com.gdg.IriON.repository.animal.AnimalRepository;
import com.gdg.IriON.repository.follow.FollowRepository;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public void follow(FollowRequestDto followRequestDto) {

        followRepository.save(
                FollowEntity.builder()
                        .animalEntity(animalRepository.findById(followRequestDto.getAnimalId()).get())
                        .userEntity(userRepository.findById(followRequestDto.getUserId()).get())
                        .follow(true)
                        .build()
        );
    }

    public void cancelFollow(FollowCancelRequestDto followCancelRequestDto) {
        Optional<FollowEntity> optionalFollow = followRepository.findByUserEntityAndAnimalEntity(
                userRepository.findById(followCancelRequestDto.getUserId()).get(),
                animalRepository.findById(followCancelRequestDto.getAnimalId()).get()
        );

        optionalFollow.ifPresent(FollowEntity::changeFollow);
    }

    @Transactional(readOnly = true)
    public Long getFollowCount(Long id) {
        return followRepository.countByAnimalEntityAndFollowIsTrue(animalRepository.findById(id).get());
    }
}
