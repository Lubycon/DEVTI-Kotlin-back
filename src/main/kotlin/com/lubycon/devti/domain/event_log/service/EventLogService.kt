package com.lubycon.devti.domain.event_log.service

import com.lubycon.devti.domain.event_log.dao.EventLogRepository
import com.lubycon.devti.domain.event_log.dto.request.EventLogPostReqDto
import com.lubycon.devti.domain.event_log.dto.response.EventLogPostResDto
import com.lubycon.devti.domain.event_log.entity.EventLog
import com.lubycon.devti.global.code.EventType
import org.springframework.stereotype.Service

@Service
class EventLogService(
    private val eventLogRepository: EventLogRepository
){

    fun createEventLog(eventLogPostReqDto: EventLogPostReqDto): EventLogPostResDto {

        val eventLog = EventLog(
            eventType = eventLogPostReqDto.eventType,
            testType = eventLogPostReqDto.testType,
            )

        return eventLogRepository.save(eventLog).toPostResDto()
    }

    fun findCountByEventType(eventType: EventType) = eventLogRepository.countAllByEventType(eventType)
}