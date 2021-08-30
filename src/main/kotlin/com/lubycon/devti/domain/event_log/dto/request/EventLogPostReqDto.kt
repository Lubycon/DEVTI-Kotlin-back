package com.lubycon.devti.domain.event_log.dto.request

import com.lubycon.devti.global.code.EventType
import com.lubycon.devti.global.code.TestType
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotNull

data class EventLogPostReqDto(

    @ApiModelProperty(value = "event type", example = "CLICK_CTA_BUTTON")
    val eventType: EventType,

    @ApiModelProperty(value = "Bucket test type", example = "TYPE_COMMON_1")
    val testType: TestType

)
