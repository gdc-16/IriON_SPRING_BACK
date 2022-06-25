package com.gdg.IriON.service;

import com.gdg.IriON.dto.UserLoginDto;
import com.gdg.IriON.dto.UserSignUpDto;
import com.gdg.IriON.entity.user.UserEntity;
import com.gdg.IriON.entity.user.UserRole;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserSignUpDto userSignUpDto) {

        if(userRepository.findByUserId(userSignUpDto.getUserId()).isPresent()){
            throw new RuntimeException("이미 있는 회원입니다.");
        }

        userRepository.save(
                UserEntity.builder()
                        .name(userSignUpDto.getName())
                        .userId(userSignUpDto.getUserId())
                        .password(userSignUpDto.getPassword())
                        .role(UserRole.USER)
                        .phoneNumber(userSignUpDto.getPhoneNumber())
                        .certificate(false)
                        .build()
        );
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<UserEntity> optionalUser = userRepository.findByUserId(userLoginDto.getUserId());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("로그인시 유저 정보 없음");
        }
        UserEntity user = optionalUser.get();

        return user.getPassword().equals(userLoginDto.getPassword());
    }
}
