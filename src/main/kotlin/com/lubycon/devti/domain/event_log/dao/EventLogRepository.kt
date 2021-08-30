package com.lubycon.devti.domain.event_log.dao

import com.lubycon.devti.domain.event_log.entity.EventLog
import com.lubycon.devti.global.code.EventType
import org.springframework.data.jpa.repository.JpaRepository

interface EventLogRepository: JpaRepository<EventLog, Long> {
    fun findAllByEventType(eventType: EventType): EventLog
    fun countAllByEventType(eventType: EventType): Long
}