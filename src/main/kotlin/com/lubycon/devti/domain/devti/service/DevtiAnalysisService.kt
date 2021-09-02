package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.global.code.BiasType
import org.springframework.stereotype.Component

@Component
interface DevtiAnalysisService {

    fun analysisAnswer(answerAttributeList: List<AnswerAttribute>): HashMap<BiasType, Int>
    fun initBiasWeightMap(): HashMap<BiasType, Float>
    fun convertWeightToPercent(weightMap: HashMap<BiasType, Float>): HashMap<BiasType, Int>
    fun classifyDevtiByPillar(biasResult: HashMap<BiasType, Int>): HashMap<BiasType, Int>




}