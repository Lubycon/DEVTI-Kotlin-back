package com.lubycon.devti.domain.event_log.service

import com.lubycon.devti.domain.event_log.dto.request.EventLogPostReqDto
import com.lubycon.devti.domain.event_log.dto.response.EventLogPostResDto
import com.lubycon.devti.global.code.EventType
import org.springframework.stereotype.Component

@Component
interface EventLogService {
    fun createEventLog(eventLogPostReqDto: EventLogPostReqDto): EventLogPostResDto
    fun findCountByEventType(eventType: EventType): Long
}