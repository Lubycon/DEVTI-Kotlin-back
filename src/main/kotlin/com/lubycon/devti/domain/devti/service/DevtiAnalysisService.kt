package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.domain.devti.dto.response.PillarWeight
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import mu.KotlinLogging
import org.springframework.stereotype.Service
import kotlin.math.log


@Service
class DevtiAnalysisService(
    private val biasService: BiasService
) {



    companion object {
        const val BIAS_CALIBRATION_VALUE: Float = 0F
        const val PILLAR_TOTAL_WEIGHT: Int = 10
    }

    fun analysisAnswer(answerAttributeList: List<AnswerAttribute>): HashMap<BiasType, Int> {

        //4가지 특성의 필러들로만 이루어진 map
        val weightMap = initBiasWeightMap()

        val pillarWeight = checkPillarWeight(answerAttributeList)

        for (answer: AnswerAttribute in answerAttributeList) {
            if (!Pillar.REFERENCE.biasList.contains(answer.bias)) {
                val newWeight: Float = weightMap.get(answer.bias)!!.plus(answer.weight)
                weightMap.replace(answer.bias, newWeight)
            }
        }


        return convertWeightToPercent(weightMap, pillarWeight)
    }


    fun checkPillarWeight(answerAttributeList: List<AnswerAttribute>): PillarWeight {
        val pillarData = answerAttributeList.groupingBy { it.bias  }.eachCount()

        val roleWeight = (pillarData.get(BiasType.V)?:0) + (pillarData.get(BiasType.A)?: 0)
        val scaleWeight = (pillarData.get(BiasType.S)?:0) + (pillarData.get(BiasType.C)?: 0)
        val interestWeight = (pillarData.get(BiasType.P)?:0) + (pillarData.get(BiasType.T)?: 0)
        val priorityWeight = (pillarData.get(BiasType.W)?:0) + (pillarData.get(BiasType.L)?: 0)

        return PillarWeight(roleWeight,scaleWeight,interestWeight,priorityWeight)

    }

    fun initBiasWeightMap(): HashMap<BiasType, Float> {

        //4가지 특성의 필러들로만 구성 된 리스트
        val biasList: List<Bias> = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList)


        //map 을 선언하여 biasType 별로 초기화
        val weightMap: HashMap<BiasType, Float> = HashMap(biasList.size)

        for (bias: Bias in biasList) {
            weightMap.put(bias.bias, BIAS_CALIBRATION_VALUE)
        }

        return weightMap
    }

    fun convertWeightToPercent(weightMap: HashMap<BiasType, Float>, pillarWeight: PillarWeight): HashMap<BiasType, Int> {
        val result: HashMap<BiasType, Int> = HashMap()

        for (biasWeight: Map.Entry<BiasType, Float> in weightMap.entries) {
            if(Pillar.ROLE.biasList.contains(biasWeight.key)) {
                result.put(biasWeight.key, Math.round(biasWeight.value / pillarWeight.roleWeight * 100))
            }

            if(Pillar.SCALE.biasList.contains(biasWeight.key)) {
                result.put(biasWeight.key, Math.round(biasWeight.value / pillarWeight.scaleWeight * 100))
            }

            if(Pillar.INTEREST.biasList.contains(biasWeight.key)) {
                result.put(biasWeight.key, Math.round(biasWeight.value / pillarWeight.interestWeight * 100))
            }

            if(Pillar.PRIORITY.biasList.contains(biasWeight.key)) {
                result.put(biasWeight.key, Math.round(biasWeight.value / pillarWeight.priorityWeight * 100))
            }
        }


        return result
    }

    fun classifyDevtiByPillar(biasResult: HashMap<BiasType, Int>): HashMap<BiasType, Int> {

        val resultMap: HashMap<BiasType, Int> = LinkedHashMap()

        for (pillar: Pillar in Pillar.values()) {

            if (pillar.equals(Pillar.REFERENCE)) {
                continue
            }

            val firstValue: Int = biasResult.get(pillar.biasList.get(0))!!
            val secondValue: Int = biasResult.get(pillar.biasList.get(1))!!

            val key: BiasType =
                if (firstValue > secondValue) pillar.biasList.get(0) else pillar.biasList.get(1)

            val value: Int = if (firstValue > secondValue) firstValue else secondValue

            resultMap.put(key, value)
        }

        return resultMap
    }
}



