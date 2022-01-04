package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.bias.MockBiasListNotInReference
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk


class DevtiAnalysisServiceTest : FunSpec() {

    private val biasService = mockk<BiasService>()
    private val devtiAnalysiService = DevtiAnalysisService(biasService)

    private val answerList = mutableListOf<AnswerAttribute>()
    private var result = HashMap<BiasType, Int>()
    private var biasResult = HashMap<BiasType, Int>()


    private val mockAnswer = MockAnswer
    private val biasList: List<Bias> = MockBiasListNotInReference.biasList

    override fun beforeEach(testCase: TestCase) {
        print("run before Test")
        for (i in 1..6) {
            answerList.add(mockAnswer.role_preset_answer(i.toLong()))
        }
        answerList.add(mockAnswer.role_gage_answer(7))

        for (i in 8..16) {
            answerList.add(mockAnswer.scale_preset_answer(i.toLong()))
        }
        for (i in 17..25) {
            answerList.add(mockAnswer.interest_preset_answer(i.toLong()))
        }
        for (i in 26..29) {
            answerList.add(mockAnswer.priority_preset_answer(i.toLong()))
        }

        for (i in 30..32) {
            answerList.add(mockAnswer.priority_gage_answer(i.toLong()))
        }
        answerList.add(mockAnswer.career())
        answerList.add(mockAnswer.job())

    }

    init {

        test("initBiasWeightMap") {
            //given
            every { biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList) } returns biasList

            //when
            val result = devtiAnalysiService.initBiasWeightMap()

            //then
            val keys = result.keys.iterator()

            result.keys.stream().count() shouldBe 8

            while (!keys.hasNext()) {
                result[keys.next()] shouldBe 0F
            }

        }

        test("checkPillarWeight") {

            //when
            println(answerList.toString())
            val result = devtiAnalysiService.checkPillarWeight(answerList)

            println(result.toString())

            //then
            result.roleWeight shouldBe 7
            result.scaleWeight shouldBe 9
            result.interestWeight shouldBe 9
            result.priorityWeight shouldBe 7
        }


        test("analysisAnswer") {
            //given
            every { biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList) } returns biasList

            //when
            result = devtiAnalysiService.analysisAnswer(answerList)
            print(result.toString())

            //then
            result.get(BiasType.V) shouldBe 100
            result.get(BiasType.A) shouldBe 0
            result.get(BiasType.P) shouldBe 100
            result.get(BiasType.T) shouldBe 0
            result.get(BiasType.S) shouldBe 100
            result.get(BiasType.C) shouldBe 0
            result.get(BiasType.W) shouldBe 100
            result.get(BiasType.L) shouldBe 0
        }


        test("classifyDevtiByPillar") {
            //given
            biasResult[BiasType.T] = 0
            biasResult[BiasType.W] = 100
            biasResult[BiasType.A] = 0
            biasResult[BiasType.C] = 0
            biasResult[BiasType.P] = 100
            biasResult[BiasType.L] = 0
            biasResult[BiasType.S] = 100
            biasResult[BiasType.V] = 100


            //when
            val result = devtiAnalysiService.classifyDevtiByPillar(biasResult)

            //then
            val keys = result.keys

        }



    }

}