package com.lubycon.devti.bdd.behavior.devti

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository
import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.domain.answer.dao.AnswerRepository
import com.lubycon.devti.domain.answer.service.AnswerService
import com.lubycon.devti.domain.bias.dao.BiasRepository
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dao.DevtiRepository
import com.lubycon.devti.domain.devti.service.DevtiAnalysisService
import com.lubycon.devti.domain.devti.service.DevtiService
import com.lubycon.devti.domain.review.dao.ReviewRepository
import com.lubycon.devti.domain.review.service.ReviewService
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.spyk
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [SpringDataConfig::class])
class DevtiFeature(
    _devtiRepository: DevtiRepository,
    _answerRepository: AnswerRepository,
    _biasRepository: BiasRepository,
    _advertisementRepository: AdvertisementRepository,
    _reviewRepository: ReviewRepository
): BehaviorSpec() {
    private val devtiRepository = spyk(_devtiRepository)
    private val answerRepository = spyk(_answerRepository)
    private val biasRepository = spyk(_biasRepository)
    private val advertisementRepository = spyk(_advertisementRepository)
    private val reviewRepository = spyk(_reviewRepository)

    private val answerService = AnswerService(answerRepository)
    private val biasService = BiasService(biasRepository)
    private val devtiAnalysiService = DevtiAnalysisService(biasService)
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

    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf

    init {
        Given("답변 저장 및 결과 요청") {
            val answerAttributeList =
            When("답변 전송") {

            }
        }
    }

}