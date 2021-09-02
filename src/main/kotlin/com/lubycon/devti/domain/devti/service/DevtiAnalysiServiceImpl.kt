package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.bias.service.BiasService
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import org.springframework.stereotype.Service

@Service
class DevtiAnalysiServiceImpl(
    private final val biasService: BiasService
) : DevtiAnalysisService {

    companion object {
        const val BIAS_CALIBRATION_VALUE: Float = 0F
        const val PILLAR_TOTAL_WEIGHT: Int = 10
    }

    override fun analysisAnswer(answerAttributeList: List<AnswerAttribute>): HashMap<BiasType, Int> {
        var weightMap = initBiasWeightMap()

        for(answer: AnswerAttribute in answerAttributeList) {
            if(!Pillar.REFERENCE.biasList.contains(answer.bias)) {
                val newWeight: Float = weightMap.get(answer.bias)!!.plus(answer.weight)
                weightMap.replace(answer.bias, newWeight)
            }
        }

        return convertWeightToPercent(weightMap)
    }

    override fun initBiasWeightMap(): HashMap<BiasType, Float> {

        val biasList: List<Bias> = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList);

        var weightMap: HashMap<BiasType, Float> = HashMap(biasList.size)

        for(bias: Bias in biasList) {
            weightMap.put(bias.bias, BIAS_CALIBRATION_VALUE)
        }

        return weightMap    }

    override fun convertWeightToPercent(weightMap: HashMap<BiasType, Float>): HashMap<BiasType, Int> {
        var result: HashMap<BiasType, Int> = HashMap()
        for (biasWeight: Map.Entry<BiasType, Float> in weightMap.entries) {
            result.put(biasWeight.key, Math.round(biasWeight.value / PILLAR_TOTAL_WEIGHT * 100))
        }

        return result
    }

    override fun classifyDevtiByPillar(biasResult: HashMap<BiasType, Int>): HashMap<BiasType, Int> {

        var resultMap: HashMap<BiasType, Int> = LinkedHashMap()

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



