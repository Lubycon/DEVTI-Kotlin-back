package com.lubycon.devti.domain.bias.service

import com.lubycon.devti.domain.bias.dao.BiasRepository
import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.global.code.BiasType
import org.springframework.stereotype.Service

@Service
class BiasServiceImpl(
    private final val biasRepository: BiasRepository
): BiasService {
    override fun findBiasListByBiasIsNotIn(biasType: List<BiasType>): List<Bias>
        = biasRepository.findAllByBiasIsNotIn(biasType)
}