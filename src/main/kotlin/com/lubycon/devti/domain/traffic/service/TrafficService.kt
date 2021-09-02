package com.lubycon.devti.domain.traffic.service

import com.lubycon.devti.domain.traffic.dao.TrafficRepository
import com.lubycon.devti.domain.traffic.entity.Traffic
import com.lubycon.devti.global.code.TestType
import org.springframework.stereotype.Service

@Service
class TrafficService(
    private val trafficRepository: TrafficRepository
) {
    fun getLastTraffic(): Traffic {
        return trafficRepository
            .findTopByOrderByIdDesc()
            .orElse(Traffic(testType = TestType.TYPE_COMMON_1))

    }

    fun saveTraffic(traffic: Traffic) = trafficRepository.save(traffic)

}