package com.lubycon.devti.domain.bias.dao

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.global.code.BiasType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BiasRepository: JpaRepository<Bias, Long> {

    fun findAllByBiasIsNotIn(biasType: List<BiasType>): List<Bias>

    @Query("SELECT b.krBias FROM Bias b where b.bias = :targetBias")
    fun findKrBiasByBias(@Param("targetBias") targetBias: String): String

}