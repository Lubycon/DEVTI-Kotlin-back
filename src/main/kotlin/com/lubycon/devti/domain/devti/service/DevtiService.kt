package com.lubycon.devti.domain.devti.service

import com.lubycon.devti.domain.answer.entity.Answer
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import com.lubycon.devti.domain.devti.dto.request.DevtiReqDto
import com.lubycon.devti.domain.devti.dto.response.BiasReviewResult
import com.lubycon.devti.domain.devti.dto.response.DevtiResDto
import com.lubycon.devti.domain.devti.entity.Devti
import com.lubycon.devti.global.code.BiasType

interface DevtiService {
    fun analysisAndCreateDevti(answerAttributeList: List<AnswerAttribute>): DevtiReqDto
    fun getDevtiByAnswer(biasResult: HashMap<BiasType, Int>, job: String): DevtiResDto
    fun getRolePillarReviewType(winBiasResult: HashMap<BiasType, Int>, job: String): Map.Entry<BiasType, String>
    fun getScalePillarReviewType(winBiasResult: HashMap<BiasType, Int>): Map.Entry<BiasType, String>
    fun getDevtiString(biasResult: HashMap<BiasType, Int>): String
    fun getBiasResults(devti: String, biasResult: HashMap<BiasType, Int>, reviewTypeMap: MutableMap<BiasType, String>)
            : List<BiasReviewResult>
    fun createDevti(answer: Answer, winBiasResult: HashMap<BiasType, Int>, biasResult: HashMap<BiasType, Int>)
            : Devti
}