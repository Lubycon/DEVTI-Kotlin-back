package com.lubycon.devti.bdd.behavior.devti

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.global.code.AnswerType
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import org.springframework.test.context.ContextConfiguration
import javax.validation.constraints.Min
import kotlin.math.sign

@ContextConfiguration(classes = [SpringDataConfig::class])
object MockAnswer {

    open fun role_preset_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.PRESET,
        sequence = Arb.long(0L,1L).single(),
        bias = Arb.element(Pillar.ROLE.biasList).single(),
        weight = 1F
    )

    open fun role_gage_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.GAGE,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.ROLE.biasList).single(),
        weight = 1F
    )

    open fun scale_preset_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.PRESET,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.SCALE.biasList).single(),
        weight = 1F
    )

    open fun scale_gage_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.GAGE,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.SCALE.biasList).single(),
        weight = 1F
    )

    open fun interest_preset_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.PRESET,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.INTEREST.biasList).single(),
        weight = 1F
    )

    open fun interest_gage_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.GAGE,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.INTEREST.biasList).single(),
        weight = 1F
    )

    open fun priority_preset_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.PRESET,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.PRIORITY.biasList).single(),
        weight = 1F
    )

    open fun priority_gage_answer(i: Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.GAGE,
        sequence = Arb.long(0L,1L).single(),
        bias =  Arb.element(Pillar.PRIORITY.biasList).single(),
        weight = 1F
    )

    fun front_back(i:Long) = AnswerAttribute (
        id = i,
        answerType = AnswerType.INFO,
        sequence = Arb.long(0L,1L).single(),
        bias =  BiasType.J,
        weight = 0F
    )

    fun career(i: Long) = AnswerAttribute(
        id = i,
        answerType = AnswerType.INFO,
        sequence = Arb.long(0L,2L).single(),
        bias =  BiasType.Y,
        weight = 0F
    )



}

