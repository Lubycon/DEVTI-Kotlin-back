package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import org.springframework.stereotype.Component

@Component
interface AnswerService {
    fun createAnswer(answerAttributList: List<AnswerAttribute>): Answer
}