package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.answer.service.AnswerService
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dao.DevtiRepository
import com.lubycon.devti.domain.devti.dto.request.DevtiReqDto
import com.lubycon.devti.domain.devti.dto.response.BiasReviewResult
import com.lubycon.devti.domain.devti.dto.response.DevtiResDto
import com.lubycon.devti.domain.devti.entity.Devti
import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import com.lubycon.devti.domain.review.entity.Review
import com.lubycon.devti.domain.review.entity.Review.Companion.toResDto
import com.lubycon.devti.domain.review.service.ReviewService
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import org.springframework.stereotype.Service
import java.util.AbstractMap
import java.util.ArrayList

@Service
class DevtiServiceImpl(
    private val answerService: AnswerService,
    private val devtiRepository: DevtiRepository,
    private val devtiAnalysisService: DevtiAnalysisService,
    private val advertisementService: AdvertisementService,
    private val biasService: BiasService,
    private val reviewService: ReviewService
) : DevtiService {
    companion object {
        const val SCALE_PILLAR_REVIEW_TYPE_THRESHOLD: Int = 50
        const val SCALE_PILLAR_REVIEW_TYPE_1: String = "1"
        const val SCALE_PILLAR_REVIEW_TYPE_2: String = "2"
        const val DESIRED_JOB_F: String = "F"
        const val DESIRED_JOB_B: String = "B"
    }

    override fun analysisAndCreateDevti(answerAttributeList: List<AnswerAttribute>): DevtiReqDto {
        var answer = answerService.createAnswer(answerAttributeList)
        var biasResult: HashMap<BiasType, Int> = devtiAnalysisService.analysisAnswer(answerAttributeList)
        var winBiasResult: HashMap<BiasType, Int> = devtiAnalysisService.classifyDevtiByPillar(biasResult)
        var job: String = if (answerAttributeList.get(40).sequence == 0L) DESIRED_JOB_F else DESIRED_JOB_B
        createDevti(answer, winBiasResult, biasResult)
        val devti = DevtiReqDto(job = job, result = biasResult.toString())

        return devti
    }

    override fun getDevtiByAnswer(biasResult: HashMap<BiasType, Int>, job: String): DevtiResDto {
        var winBiasResult: HashMap<BiasType, Int> = devtiAnalysisService.classifyDevtiByPillar(biasResult)
        val devtiString = getDevtiString(winBiasResult)
        var reviewTypeMap: MutableMap<BiasType, String> = HashMap()
        val roleReviewType: Map.Entry<BiasType, String> = getRolePillarReviewType(winBiasResult, job)
        val scalePillarReviewType: Map.Entry<BiasType, String> = getScalePillarReviewType(winBiasResult)

        reviewTypeMap.put(roleReviewType.key, roleReviewType.value)
        reviewTypeMap.put(scalePillarReviewType.key, scalePillarReviewType.value)

        val generalReview: Review = reviewService.findByReviewType(devtiString)

        return DevtiResDto(
            devti = devtiString,
            devtiTitle = generalReview.headline,
            generalReview = Review.toResDto(generalReview),
            biasResults = getBiasResults(devtiString, biasResult, reviewTypeMap),
            advertisementList = advertisementService.findAll()
        )    }

    override fun getRolePillarReviewType(winBiasResult: HashMap<BiasType, Int>, job: String): Map.Entry<BiasType, String> {
        val rolePillarBias: Map.Entry<BiasType, Int> = winBiasResult.entries.stream()
            .filter { bias: Map.Entry<BiasType?, Int?> ->
                Pillar.ROLE.biasList.contains(
                    bias.key
                )
            }.findFirst()
            .orElse(AbstractMap.SimpleEntry(BiasType.V, 75))

        return AbstractMap.SimpleEntry(rolePillarBias.key, rolePillarBias.key.toString() + job)
    }

    override fun getScalePillarReviewType(winBiasResult: HashMap<BiasType, Int>): Map.Entry<BiasType, String> {
        val scalePillarBias: Map.Entry<BiasType, Int> = winBiasResult.entries.stream()
            .filter { bias: Map.Entry<BiasType, Int> ->
                Pillar.SCALE.biasList.contains(
                    bias.key
                )
            }.findFirst()
            .orElse(AbstractMap.SimpleEntry(BiasType.S, 75))
        val weight = scalePillarBias.value
        val weightType =
            if (weight <= SCALE_PILLAR_REVIEW_TYPE_THRESHOLD) SCALE_PILLAR_REVIEW_TYPE_1 else SCALE_PILLAR_REVIEW_TYPE_2
        return AbstractMap.SimpleEntry(scalePillarBias.key, scalePillarBias.key.toString() + weightType)
    }

    override fun getDevtiString(biasResult: HashMap<BiasType, Int>): String {
        var devtiString: String = ""

        for (biasMap: Map.Entry<BiasType, Int> in biasResult.entries) {
            devtiString += biasMap.key.toString()
        }

        return devtiString    }

    override fun getBiasResults(
        devti: String,
        biasResult: HashMap<BiasType, Int>,
        reviewTypeMap: MutableMap<BiasType, String>
    ): List<BiasReviewResult> {
        val biasList: List<Bias> = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList)
        val biasReviewResults: MutableList<BiasReviewResult> = ArrayList(8)

        for (bias: Bias in biasList) {
            val biasType: BiasType = bias.bias
            val winnerBias: Boolean = devti.indexOf(biasType.toString()) > -1

            var reviewResDto = ReviewResDto(title = null, contents = null)


            if (winnerBias) {
                var reviewType: String =
                    if (reviewTypeMap.get(biasType) == null) bias.bias.toString() else reviewTypeMap.get(biasType)!!
                val review = reviewService.findByReviewType(reviewType)
                reviewResDto = toResDto(review)
            }

            var biasReviewResult =
                BiasReviewResult(
                    bias = bias,
                    review = reviewResDto,
                    weight = biasResult.get(biasType)
                )

            biasReviewResults.add(biasReviewResult)
        }

        return biasReviewResults    }

    override fun createDevti(
        answer: Answer,
        winBiasResult: HashMap<BiasType, Int>,
        biasResult: HashMap<BiasType, Int>
    ): Devti {
        val devti = Devti(answer = answer, devti = getDevtiString(winBiasResult), devtiResult = biasResult.toString())
        return devtiRepository.save(devti)
    }
}