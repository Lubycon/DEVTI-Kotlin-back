package com.lubycon.devti.domain.bias.dao

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.global.code.BiasType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BiasRepository: JpaRepository<Bias, Long> {

    fun findAllByBiasIsNotIn(biasType: List<BiasType>): List<Bias>
}