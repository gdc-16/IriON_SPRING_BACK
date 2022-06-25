package com.gdg.IriON.service;

import com.gdg.IriON.dto.QuizRequestDto;
import com.gdg.IriON.entity.user.UserEntity;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuizService {

    private final UserRepository userRepository;

    public boolean doQuiz(QuizRequestDto quizRequestDto) {
        Optional<UserEntity> optionalUser = userRepository.findByUserId(quizRequestDto.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("doQuiz 맞는 유저가 없음");
        }


        int score = 0;
        for (QuizRequestDto.QuizDto quizDto : quizRequestDto.getQuiz()) {
            if (quizDto.getQuiz().equals("문항")) {
                score += 10;
            }
        }
        if (score > 80) {
            final UserEntity userEntity = optionalUser.get();
            userEntity.passQuiz();
            return true;
        }
        return false;
    }
}
