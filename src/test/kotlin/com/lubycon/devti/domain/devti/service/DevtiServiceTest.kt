package com.lubycon.devti.domain.devti.service

import com.google.gson.Gson
import com.lubycon.devti.bdd.behavior.devti.MockAnswer
import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository
import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.answer.service.AnswerService
import com.lubycon.devti.domain.bias.dao.BiasRepository
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dao.DevtiRepository
import com.lubycon.devti.domain.review.dao.ReviewRepository
import com.lubycon.devti.domain.review.service.ReviewService
import com.lubycon.devti.global.code.BiasType
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.extensions.spring.SpringExtension
import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DevtiServiceTest(
    devtiRepository: DevtiRepository,
    answerRepository: AnswerRepository,
    biasRepository: BiasRepository,
    advertisementRepository: AdvertisementRepository,
    reviewRepository: ReviewRepository
): FunSpec() {

    private val answerService = AnswerService(answerRepository)
    private val biasService = BiasService(biasRepository)
    private val devtiAnalysiService = DevtiAnalysiService(biasService)
    private val advertisementService = AdvertisementService(advertisementRepository)
    private val reviewService = ReviewService(reviewRepository)

    private val devtiService = DevtiService(
        answerService,
        devtiRepository,
        devtiAnalysiService,
        advertisementService,
        biasService,
        reviewService
    )

    override fun extensions() = listOf(SpringExtension)
    private val answerList = mutableListOf<AnswerAttribute>()
    private val mockAnswer = MockAnswer


    override fun beforeTest(testCase: TestCase) {
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

        print("m")
    }

    private var result  = HashMap<BiasType, Int>()

    init {

        test("analysisAnswer") {
            val string = Gson().toJson(answerList)
            print(string)
            result = devtiAnalysiService.analysisAnswer(answerList)
            print(result.toString())
        }

        test("analysisAnswerAndcreateDevti") {
            print(devtiService.analysisAndCreateDevti(answerList))
        }
    }




}