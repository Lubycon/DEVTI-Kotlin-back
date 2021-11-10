package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private val answerRepository: AnswerRepository
) {
     fun createAnswer(answerAttributeList: List<AnswerAttribute>)
     = answerRepository.save(Answer(answerList = answerAttributeList))
}