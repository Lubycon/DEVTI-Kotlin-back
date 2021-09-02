package com.lubycon.devti.domain.event_log.api


import com.lubycon.devti.domain.event_log.dto.request.EventLogPostReqDto
import com.lubycon.devti.domain.event_log.dto.response.EventLogPostResDto
import com.lubycon.devti.domain.event_log.service.EventLogService
import com.lubycon.devti.global.code.EventType
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/event-log")
@Api(value = "EventLog")
class EventLogController(
    private val eventLogService: EventLogService
) {

    @PostMapping
    @ApiOperation(value = "Event log 저장")
    fun create(@RequestBody eventLogPostReqDto: @Valid EventLogPostReqDto
    ): ResponseEntity<EventLogPostResDto> {
        return ResponseEntity.ok(eventLogService.createEventLog(eventLogPostReqDto))
    }

    @GetMapping(value = ["/{eventType}"])
    @ApiOperation(value = "Event 발생 횟수 조회")
    fun getEventCount(
        @PathVariable eventType: EventType
    ): ResponseEntity<Long> {
        return ResponseEntity.ok(eventLogService.findCountByEventType(eventType))
    }
}