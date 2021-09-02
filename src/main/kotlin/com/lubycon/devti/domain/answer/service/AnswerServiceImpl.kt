package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import org.springframework.stereotype.Service

@Service
class AnswerServiceImpl(
    private val answerRepository: AnswerRepository
): AnswerService {
    override fun createAnswer(answerAttributList: List<AnswerAttribute>)
        = answerRepository.save(Answer(answerList = answerAttributList))
}