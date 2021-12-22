package com.lubycon.devti.domain.devti.dao

import com.lubycon.devti.domain.devti.entity.Devti
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DevtiRepository: JpaRepository<Devti, Long> {

    @Query("SELECT devti FROM Devti ")
    fun selectDevti() : List<String>
}