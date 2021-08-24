package com.lubycon.devti.domain.traffic.dao

import com.lubycon.devti.domain.traffic.entity.Traffic
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TrafficRepository: JpaRepository<Traffic, Long> {
    fun findTopByOrderByIdDesc(): Optional<Traffic>
}