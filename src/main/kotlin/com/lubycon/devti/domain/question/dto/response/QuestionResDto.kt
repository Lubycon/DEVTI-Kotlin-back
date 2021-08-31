package com.lubycon.devti.domain.question.dto.response

import com.lubycon.devti.global.code.AnswerType

data class QuestionResDto(
    val id: Long,
    val title: String,
    val answerType: AnswerType
)
