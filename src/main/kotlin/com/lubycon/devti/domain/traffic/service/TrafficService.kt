package com.lubycon.devti.domain.traffic.service

import com.lubycon.devti.domain.traffic.entity.Traffic
import org.springframework.stereotype.Component

@Component
interface TrafficService {
    fun getLastTraffic(): Traffic
    fun saveTraffic(traffic: Traffic): Traffic
}