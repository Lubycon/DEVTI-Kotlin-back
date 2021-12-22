package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.answer.service.AnswerService
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dao.DevtiRepository
import com.lubycon.devti.domain.devti.dto.request.DevtiReqDto
import com.lubycon.devti.domain.devti.dto.response.*
import com.lubycon.devti.domain.devti.entity.Devti
import com.lubycon.devti.domain.review.dto.response.GeneralReviewDto
import com.lubycon.devti.domain.review.entity.Review
import com.lubycon.devti.domain.review.entity.Review.Companion.toResDto
import com.lubycon.devti.domain.review.service.ReviewService
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

private val logger = KotlinLogging.logger {}

@Service
class DevtiService(
    private val answerService: AnswerService,
    private val devtiRepository: DevtiRepository,
    private val devtiAnalysisService: DevtiAnalysisService,
    private val advertisementService: AdvertisementService,
    private val biasService: BiasService,
    private val reviewService: ReviewService
) {
    companion object {
        const val SCALE_PILLAR_REVIEW_TYPE_THRESHOLD: Int = 75
        const val SCALE_PILLAR_REVIEW_TYPE_1: String = "1"
        const val SCALE_PILLAR_REVIEW_TYPE_2: String = "2"
        const val DESIRED_JOB_F: String = "F"
        const val DESIRED_JOB_B: String = "B"

        val devtiMap = mapOf<Char, String>(
            'V' to "시각화",
            'A' to "설계",
            'S' to "스타트업",
            'C' to "대기업",
            'P' to "프로덕트",
            'T' to "테크",
            'W' to "워라하",
            'L' to "워라벨"
        )

        var biasMap : LinkedHashMap<String, BiasReviewResult> = mutableMapOf<String, BiasReviewResult>(
            "VA" to BiasReviewResult(),
            "PT" to BiasReviewResult(),
            "SC" to BiasReviewResult(),
            "WL" to BiasReviewResult()
        ) as LinkedHashMap<String, BiasReviewResult>


    }


    fun analysisAndCreateDevti(answerAttributeList: List<AnswerAttribute>): DevtiReqDto {

        val answer = answerService.createAnswer(answerAttributeList)
        val biasResult: HashMap<BiasType, Int> = devtiAnalysisService.analysisAnswer(answerAttributeList)
        val winBiasResult: HashMap<BiasType, Int> = devtiAnalysisService.classifyDevtiByPillar(biasResult)
        //job
        val job: String = if (answerAttributeList.get(33).sequence == 0L) DESIRED_JOB_F else DESIRED_JOB_B

        createDevti(answer, winBiasResult, biasResult)

        return DevtiReqDto(job = job, result = biasResult)
    }


    fun getDevtiByAnswer(biasResult: HashMap<BiasType, Int>, job: String): DevtiResDto {

        val winBiasResult: LinkedHashMap<BiasType, Int> = devtiAnalysisService.classifyDevtiByPillar(biasResult)
        val devtiString = getDevtiString(winBiasResult)

        val reviewTypeMap: MutableMap<BiasType, String> = HashMap()

        val roleReviewType: Map.Entry<BiasType, String> = getRolePillarReviewType(winBiasResult, job)
        logger.info { "role " + roleReviewType.toString() } //VF
        val scalePillarReviewType: Map.Entry<BiasType, String> = getScalePillarReviewType(winBiasResult)
        logger.info { "scale " + scalePillarReviewType.toString() }

        reviewTypeMap.put(roleReviewType.key, roleReviewType.value)
        reviewTypeMap.put(scalePillarReviewType.key, scalePillarReviewType.value)

        val generalReview: Review = reviewService.findByReviewType(devtiString).get(0)

        return DevtiResDto(
            devti = getDevtiString(winBiasResult),
            devtiTitle = generalReview.headline,
            generalReview = toResDto(generalReview),
            biasResults = getBiasResults(devtiString, biasResult, reviewTypeMap),
            advertisementList = advertisementService.findAll(),
            devtiRatioList = getDevtiRatio()
        )
    }

    fun getDevtiByAnswer_v2(biasResult: HashMap<BiasType, Int>, job: String): DevtiResDto2 {

        val winBiasResult: LinkedHashMap<BiasType, Int> = devtiAnalysisService.classifyDevtiByPillar(biasResult)

        logger.info { "winBias : " + winBiasResult.toString()  }
        val devtiString = getDevtiString(winBiasResult)

        val reviewTypeMap: MutableMap<BiasType, String> = HashMap()
        val roleReviewType: Map.Entry<BiasType, String> = getRolePillarReviewType(winBiasResult, job)
        val scalePillarReviewType: Map.Entry<BiasType, String> = getScalePillarReviewType(winBiasResult)

        reviewTypeMap.put(roleReviewType.key, roleReviewType.value)
        reviewTypeMap.put(scalePillarReviewType.key, scalePillarReviewType.value)

        val generalReview: Review = reviewService.findByReviewType(devtiString).get(0)


        return DevtiResDto2(
            generalReview = getGeneralReview(devtiString, job),
            biasResults = getBiasResults2(devtiString, biasResult, reviewTypeMap),
            advertisementList = advertisementService.findAll(),
            devtiRatioList = getDevtiRatio()
        )
    }

    fun getGeneralReview(devti: String, job: String): GeneralReviewDto {

        val review: Review = reviewService.findByReviewType(devti).get(0)
        val getAV = reviewService.findByReviewType(devti[0].toString() + job).first().contents
        val getPT = reviewService.findByReviewType(devti[1].toString()).first().contents
        val summaryList = listOf<String>(getAV, getPT)

        val content = StringBuilder()

        for (pillar: Char in devti) {
            content.append(devtiMap[pillar]).append("/")
        }

        content.deleteCharAt(content.lastIndexOf("/"))


        return GeneralReviewDto(
            result = devti,
            title = review.contents,
            content = content.toString(),
            summaryReview = summaryList
        )

    }

    fun getRolePillarReviewType(winBiasResult: HashMap<BiasType, Int>, job: String): Map.Entry<BiasType, String> {
        val rolePillarBias: Map.Entry<BiasType, Int> = winBiasResult.entries.stream()
            .filter { bias: Map.Entry<BiasType?, Int?> ->
                Pillar.ROLE.biasList.contains(
                    bias.key
                )
            }.findFirst()
            .orElse(AbstractMap.SimpleEntry(BiasType.V, 75))

        return AbstractMap.SimpleEntry(rolePillarBias.key, rolePillarBias.key.toString() + job)
    }

    fun getScalePillarReviewType(winBiasResult: HashMap<BiasType, Int>): Map.Entry<BiasType, String> {
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

    fun getDevtiString(biasResult: HashMap<BiasType, Int>): String {
        var devtiString = ""

        for (biasMap: Map.Entry<BiasType, Int> in biasResult.entries) {
            devtiString += biasMap.key.toString()
        }

        return devtiString
    }

    fun getBiasResults(
        devti: String,
        biasResult: HashMap<BiasType, Int>,
        reviewTypeMap: MutableMap<BiasType, String>
    ): List<BiasReviewResult> {

        val biasList: List<Bias> = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList)
        val biasReviewResults: MutableList<BiasReviewResult> = ArrayList(8)

        for (bias: Bias in biasList) {
            logger.info { "CHEK BIAS : " + bias.bias.toString() }
            val biasType: BiasType = bias.bias
            val winnerBias: Boolean = devti.indexOf(biasType.toString()) > -1
            var contentsList: List<String> = ArrayList<String>()
            var biasTitle: String = ""

            logger.info { "?????" + reviewTypeMap.toString() }

            if (winnerBias) {
                val reviewType: String =
                    if (reviewTypeMap.get(biasType) == null) bias.bias.toString() else reviewTypeMap.get(biasType)!!
                contentsList = reviewService.findContentsByReviewType(reviewType)
                logger.info { "check " + reviewType + "???" + contentsList.toString() }

                biasTitle = reviewService.findByReviewType(reviewType).first().title
            }
            val biasReviewResult =
                BiasReviewResult(
                    bias = bias.bias.toString(),
                    weight = biasResult.get(biasType),
                    biasTitle = biasTitle,
                    reviewList = contentsList
                )
            biasReviewResults.add(biasReviewResult)




        }

        for(biasReview : BiasReviewResult in biasReviewResults) {
            for ((key, value) in biasMap) {
                if (key.contains(biasReview.bias) && devti.contains(biasReview.bias)) {
                    biasMap[key] = biasReview
                }
            }
        }

        logger.info { "please!! : " + biasMap }
        return biasReviewResults
    }
    fun getBiasResults2(
        devti: String,
        biasResult: HashMap<BiasType, Int>,
        reviewTypeMap: MutableMap<BiasType, String>
    ): MutableMap<String, BiasReviewResult> {

        val biasList: List<Bias> = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList)
        val biasReviewResults: MutableList<BiasReviewResult> = ArrayList(8)

        for (bias: Bias in biasList) {
            logger.info { "CHEK BIAS : " + bias.bias.toString() }
            val biasType: BiasType = bias.bias
            val winnerBias: Boolean = devti.indexOf(biasType.toString()) > -1
            var contentsList: List<String> = ArrayList<String>()
            var biasTitle: String = ""

            logger.info { "?????" + reviewTypeMap.toString() }

            if (winnerBias) {
                val reviewType: String =
                    if (reviewTypeMap.get(biasType) == null) bias.bias.toString() else reviewTypeMap.get(biasType)!!
                contentsList = reviewService.findContentsByReviewType(reviewType)
                logger.info { "check " + reviewType + "???" + contentsList.toString() }

                biasTitle = reviewService.findByReviewType(reviewType).first().title
            }
            val biasReviewResult =
                BiasReviewResult(
                    bias = bias.bias.toString(),
                    weight = biasResult.get(biasType),
                    biasTitle = biasTitle,
                    reviewList = contentsList
                )
            biasReviewResults.add(biasReviewResult)




        }

        for(biasReview : BiasReviewResult in biasReviewResults) {
            for ((key, value) in biasMap) {
                if (key.contains(biasReview.bias) && devti.contains(biasReview.bias)) {
                    biasMap[key] = biasReview
                }
            }
        }


        return biasMap
    }


    fun createDevti(
        answer: Answer,
        winBiasResult: HashMap<BiasType, Int>,
        biasResult: HashMap<BiasType, Int>
    ): Devti {
        val devti =
            Devti(answer = answer, devti = getDevtiString(winBiasResult), devtiResult = biasResult.toString())
        return devtiRepository.save(devti)
    }

    fun getDevtiRatio(): ArrayList<DevtiRatioDto> {

        val devtiList: List<String> = devtiRepository.selectDevti();
        val totalCount: Int = devtiList.size
        val data = devtiList.groupingBy { it }.eachCount();
        val results = data.toList().sortedByDescending { (_, value) -> value }.toMap()
        var count = 0;

        var devtiRatioList = ArrayList<DevtiRatioDto>()

        for (key in results.keys) {
            if (count == 3) break;
            val ratio = (results.getValue(key).toDouble() / totalCount) * 100
            devtiRatioList.add(DevtiRatioDto(key, ratio))
            count++;
        }
        return devtiRatioList
    }

}

