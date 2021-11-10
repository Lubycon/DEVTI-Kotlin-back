package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class AnswerServiceKotest: FunSpec() {

    private val answerRepository = mockk<AnswerRepository>()
    private val answerService = AnswerService(answerRepository)

    private val answerList = mutableListOf<AnswerAttribute>()
    private val mockAnswer = MockAnswer

    override fun beforeTest(testCase: TestCase) {
        for (i in 1..6) {
            answerList.add(mockAnswer.role_preset_answer(i.toLong()))
        }

        answerList.add(mockAnswer.role_gage_answer(7))

        for (i in 8..15) {
            answerList.add(mockAnswer.scale_preset_answer(i.toLong()))
        }

        for (i in 16..23) {
            answerList.add(mockAnswer.interest_preset_answer(i.toLong()))
        }
        for (i in 24..27) {
            answerList.add(mockAnswer.priority_preset_answer(i.toLong()))
        }

        for (i in 28..29) {
            answerList.add(mockAnswer.priority_gage_answer(i.toLong()))
        }
        answerList.add(mockAnswer.career())
        answerList.add(mockAnswer.job())
    }

    init {
        test(" 답안생성하기 ") {

            //given
            val answer = Answer(1L, answerList)
            every { answerRepository.save(any()) } returns answer

            //when
            val result = answerService.createAnswer(answerList)

            //then
            answerList.size.shouldBe(31)
            result.shouldNotBeNull()

        }
    }
}