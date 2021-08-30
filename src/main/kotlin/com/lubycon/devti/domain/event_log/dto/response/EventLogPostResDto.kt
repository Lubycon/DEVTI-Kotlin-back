package com.lubycon.devti.domain.event_log.dto.response

import com.lubycon.devti.global.code.EventType
import com.lubycon.devti.global.code.TestType
import io.swagger.annotations.ApiModelProperty

data class EventLogPostResDto(

    private val id: Long,

    private val eventType: EventType,

    private val testType: TestType

)
