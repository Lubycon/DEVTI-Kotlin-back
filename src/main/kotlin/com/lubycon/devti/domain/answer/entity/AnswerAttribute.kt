package com.lubycon.devti.domain.answer.entity

import com.lubycon.devti.global.code.AnswerType
import com.lubycon.devti.global.code.BiasType
import javax.validation.constraints.Min

class AnswerAttribute(
    val id: Long,
    val answerType: AnswerType,
    val sequence: Long,
    val bias: BiasType,
    @Min(0)
    val weight: Float
)