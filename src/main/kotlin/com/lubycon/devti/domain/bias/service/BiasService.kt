package com.lubycon.devti.domain.bias.service

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.global.code.BiasType
import org.springframework.stereotype.Component

@Component
interface BiasService {
    fun findBiasListByBiasIsNotIn(biasType: List<BiasType>): List<Bias>
}