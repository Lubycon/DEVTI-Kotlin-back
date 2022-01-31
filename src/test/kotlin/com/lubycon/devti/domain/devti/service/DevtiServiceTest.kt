package com.lubycon.devti.domain.devti.service

import com.google.gson.Gson
import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.answer.service.AnswerService
import com.lubycon.devti.domain.bias.MockBiasListNotInReference
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dao.DevtiRepository
import com.lubycon.devti.domain.review.entity.Review
import com.lubycon.devti.domain.review.service.ReviewService
import com.lubycon.devti.global.code.BiasType
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.mockk.mockk

class DevtiServiceTest : FunSpec() {

    private val answerService = mockk<AnswerService>()
    private val biasService = mockk<BiasService>()
    private val devtiAnalysiService = mockk<DevtiAnalysisService>()
    private val advertisementService = mockk<AdvertisementService>()
    private val reviewService = mockk<ReviewService>()
    private val devtiRepository = mockk<DevtiRepository>()


    private val devtiService = DevtiService(
        answerService,
        devtiRepository,
        devtiAnalysiService,
        advertisementService,
        biasService,
        reviewService
    )

    private val answerList = mutableListOf<AnswerAttribute>()
    private var result = HashMap<BiasType, Int>()
    private val winBiasResult = LinkedHashMap<BiasType, Int>()
    private val biasList: List<Bias> = MockBiasListNotInReference.biasList
    private var mockAnswer = MockAnswer

    var review = Review(
        id = 2L,
        reviewType = "VSPW",
        headline = "열정적인 꿈을 가진 당신은 야망가 VSPW",
        title = "당신은 VSPW",
        emoji = "emoji",
        contents = "열정적인 꿈을 가진 당신은 VSPW"
    )

    private var reviewTypeMap: MutableMap<BiasType, String> = HashMap();


    override fun beforeTest(testCase: TestCase) {
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

        result[BiasType.V] = 100
        result[BiasType.A] = 0
        result[BiasType.S] = 100
        result[BiasType.C] = 0
        result[BiasType.P] = 100
        result[BiasType.T] = 0
        result[BiasType.W] = 100
        result[BiasType.L] = 0
        result[BiasType.J] = 0 // 프론트
        result[BiasType.Y] = 0 // 0 ~ 1년차


        winBiasResult[BiasType.V] = 100
        winBiasResult[BiasType.S] = 100
        winBiasResult[BiasType.P] = 100
        winBiasResult[BiasType.W] = 100

        reviewTypeMap.put(BiasType.V, "VF")
        reviewTypeMap.put(BiasType.S, "S2")

    }


    init {
        test("temp") {

            val gson = Gson()
            val jsonString = gson.toJson(answerList)

            println(jsonString)

        }
//
//        test("getDevtiByAnswer") {
//            //given
//            every { devtiAnalysiService.classifyDevtiByPillar(any()) } returns winBiasResult
//            every { reviewService.findByReviewType(any()) } returns emptyList()
//            every { biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList) } returns biasList
//            every { advertisementService.findAll() } returns emptyList()
//
//            //when
//            val result = devtiService.getDevtiByAnswer(result, "F")
//
//            //then
//            println(result)
//
//            result.devti shouldBe "VSPW"
//
//
//        }
//
//        test("getDevtiString") {
//            //when
//            val result = devtiService.getDevtiString(winBiasResult)
//
//            //then
//            result shouldBe "VSPW"
//        }
//
//        test("getRolePillarReviewType") {
//
//            //when
//            val result = devtiService.getRolePillarReviewType(winBiasResult, "F")
//
//            //then
//            result.value shouldBe "VF"
//
//        }
//
//        test("getScalePillarReviewType") {
//            //when
//            val result = devtiService.getScalePillarReviewType(winBiasResult)
//
//            //then
//            println(result)
//            result.value shouldBe "S2"
//        }
//
//        test("getBiasResults") {
//            //given
//            every { biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList) } returns biasList
//            every { reviewService.findByReviewType(any()) } returns emptyList()
//
//            //when
//            val result2 = devtiService.getBiasResults("VSPW", result, reviewTypeMap)
//
//            //then
//            println("?" + result2.toString())
//        }
//
    }


}




