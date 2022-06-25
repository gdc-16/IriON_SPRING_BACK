package com.gdg.IriON.service;

import com.gdg.IriON.dto.QuizRequestDto;
import com.gdg.IriON.entity.user.UserEntity;
import com.gdg.IriON.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
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
            if (quizDto.getQuiz().equals("강아지를 처음 집으로 데리고 왔을 때 당신의 행동은?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("강아지를 데리고 온 날 밤에는 강아지는 어디에 있을것인가? ") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("강아지 교육은 언제 하는것이 좋을까요?") && quizDto.getAnswer()==1) {
                score += 10;
            } else if (quizDto.getQuiz().equals("가장 효율적인 교육방법은?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("당신이 저녁을 먹고 있을때, 강아지가 달라는 눈빛을 할때 어떻게 하겠는가?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("일을 마치고 온 당신, 강아지가 행복하고 신나게 당신한테 뛰어든다. 이때 당신의 행동은?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("강아지를 남기고 일을 나갈때 당신은 어떻게 행동할 것인가?") && quizDto.getAnswer()==1) {
                score += 10;
            } else if (quizDto.getQuiz().equals("당신이 나간사이 강아지가 사고를 친 거 같다. 이때 첫번째로 할 당신의 행동은?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("강아지를 키울때 어떻게 키울것인가?") && quizDto.getAnswer()==2) {
                score += 10;
            } else if (quizDto.getQuiz().equals("강아지가 어리다면 어떻게 키울것인가?") && quizDto.getAnswer()==1) {
                score += 10;
            }

        }
        if (score >= 70) {
            final UserEntity userEntity = optionalUser.get();
            userEntity.passQuiz();
            return true;
        }
        return false;
    }
}
