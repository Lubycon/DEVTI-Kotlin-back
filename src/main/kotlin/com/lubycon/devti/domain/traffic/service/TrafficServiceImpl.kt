package com.lubycon.devti.domain.traffic.service

import com.lubycon.devti.domain.traffic.dao.TrafficRepository
import com.lubycon.devti.domain.traffic.entity.Traffic
import com.lubycon.devti.global.code.TestType
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {  }

@Service
class TrafficServiceImpl(
    private val trafficRepository: TrafficRepository
): TrafficService {
    override fun getLastTraffic(): Traffic {
        logger.info { "getLast Traffic Start" }
//        val tmp = (trafficRepository.findTopByOrderByIdDesc() ?: Traffic(testType = TestType.TYPE_COMMON_1)) as Traffic
        var tmp :Traffic
//
        tmp = trafficRepository
            .findTopByOrderByIdDesc()
            .orElse(Traffic(testType = TestType.TYPE_COMMON_1))

//        tmp = Traffic(testType = TestType.TYPE_COMMON_1)

        logger.info { "return 입니다. $tmp" }
        return tmp

    }

    override fun saveTraffic(traffic: Traffic) = trafficRepository.save(traffic)

}
