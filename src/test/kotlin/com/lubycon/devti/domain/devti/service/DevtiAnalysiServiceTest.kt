package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.global.code.BiasType
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class DevtiAnalysiServiceTest(val devtiAnalysiService: DevtiAnalysiService) : FunSpec() {

    override fun extensions() = listOf(SpringExtension)

    private val answerList = mutableListOf<AnswerAttribute>()
    private var result = HashMap<BiasType, Int>()
    private val mockAnswer = MockAnswer


    override fun beforeTest(testCase: TestCase) {
        print("run before Test")
        for (i in 1..5) {
            answerList.add(mockAnswer.role_preset_answer(i.toLong()))
        }
        for (i in 6..10) {
            answerList.add(mockAnswer.scale_preset_answer(i.toLong()))
        }
        for (i in 11..15) {
            answerList.add(mockAnswer.interest_preset_answer(i.toLong()))
        }
        for (i in 16..20) {
            answerList.add(mockAnswer.priority_preset_answer(i.toLong()))
        }
    }

    init {
        test("analysisAnswer") {
            result = devtiAnalysiService.analysisAnswer(answerList)
            print(result.toString())
        }
    }

}