package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute

interface AnswerService {
    fun createAnswer(answerAttributList: List<AnswerAttribute>): Answer
}