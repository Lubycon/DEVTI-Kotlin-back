package com.lubycon.devti.domain.traffic.service

import com.lubycon.devti.domain.traffic.dao.TrafficRepository
import com.lubycon.devti.domain.traffic.entity.Traffic
import com.lubycon.devti.global.code.TestType
import org.springframework.stereotype.Service

@Service
class TrafficServiceImpl(
    private val trafficRepository: TrafficRepository
): TrafficService {
    override fun getLastTraffic(): Traffic {
        return (trafficRepository.findTopByOrderByIdDesc() ?: Traffic(testType = TestType.TYPE_COMMON_1)) as Traffic

    }

    override fun saveTraffic(traffic: Traffic) = trafficRepository.save(traffic)

}