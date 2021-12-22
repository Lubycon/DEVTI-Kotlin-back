package com.lubycon.devti.domain.answer.service

import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import io.kotest.core.spec.BeforeTest
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given

@ExtendWith(MockKExtension::class)
@DisplayName("서비스 유닛 테스트 (mock)")
class AnswerServiceTest {

    private val answerRepository = mockk<AnswerRepository>()
    private val answerService = AnswerService(answerRepository)


    private val answerList = mutableListOf<AnswerAttribute>()
    private val mockAnswer = MockAnswer

    @BeforeEach
    fun setUp() {

        print("run before Test")

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

        for(i in 28..29) {
            answerList.add(mockAnswer.priority_gage_answer(i.toLong()))
        }
        answerList.add(mockAnswer.career())
        answerList.add(mockAnswer.job())
    }

    @Test
    @DisplayName("답안생성")
    fun createAnswer() {
        //given
        val answer = Answer(1L, answerList);
        every { answerRepository.save(any()) } returns answer


        //when
        val result = answerService.createAnswer(answerList)

        //then
        print(result.toString())


    }




}