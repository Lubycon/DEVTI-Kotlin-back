package com.lubycon.devti.domain.event_log.entity

import com.lubycon.devti.domain.event_log.dto.response.EventLogPostResDto
import com.lubycon.devti.global.code.EventType
import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class EventLog(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_log_id")
    private val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private val eventType: EventType,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    private val testType: TestType
): BaseTimeEntity() {

    fun toPostResDto(): EventLogPostResDto {
        return EventLogPostResDto(
            id = id,
            eventType = eventType,
            testType = testType
        )
    }


}