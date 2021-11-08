package com.lubycon.devti.domain.question.api

import com.lubycon.devti.domain.question.service.QuestionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
@Api(value = "Question")
class QuestionController(
    private val questionService: QuestionService
) {

    @GetMapping
    @ApiOperation(value = "모든 질문 및 선택 가져오기")
    fun getAllQuestionAndPreset() = ResponseEntity.ok(questionService.findAllQuestionAndPreset())
}
