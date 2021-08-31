package com.lubycon.devti.domain.question.service

import com.lubycon.devti.domain.question.dto.response.QuestionListResDto
import com.lubycon.devti.domain.question.dto.response.QuestionResDto
import com.lubycon.devti.domain.question.entity.Question
import org.springframework.stereotype.Component

@Component
interface QuestionService {
    fun findAllQuestionAndPreset(): List<QuestionListResDto>
    fun setQuestionResDto(question: Question): QuestionListResDto
}