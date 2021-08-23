package com.lubycon.devti.domain.survey.api


import com.lubycon.devti.domain.survey.service.SurveyService
import com.lubycon.devti.domain.survey.dto.SurveyPostReqDto
import com.lubycon.devti.domain.survey.dto.SurveyPostResDto
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/survey")
@Api(value = "Survey")
class SurveyController(
    private val surveyService: SurveyService
) {

    @PostMapping
    @ApiOperation(value = "사전 참여 신청")
    fun create(
        @RequestBody @Valid surveyPostReqDto: SurveyPostReqDto
    ): ResponseEntity<SurveyPostResDto> {
        return ResponseEntity.ok(surveyService.createSurvey(surveyPostReqDto))
    }

}