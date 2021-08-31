package com.lubycon.devti.domain.question.service

import com.lubycon.devti.domain.preset.service.PresetService
import com.lubycon.devti.domain.question.dao.QuestionRepository
import com.lubycon.devti.domain.question.dto.response.QuestionListResDto
import com.lubycon.devti.domain.question.dto.response.QuestionResDto
import com.lubycon.devti.domain.question.dto.response.convertResponseDto
import com.lubycon.devti.domain.question.entity.Question
import org.springframework.stereotype.Service

@Service
class QuestionServiceImpl(
    private final val questionRepository: QuestionRepository,
    private final val presetService: PresetService
): QuestionService {

    override fun findAllQuestionAndPreset(): List<QuestionListResDto> {
        val questionList = questionRepository.findAll()
        val allQuestionAndPresetResDtoList = mutableListOf<QuestionListResDto>()

        questionList.stream()
            .forEach {
                question -> allQuestionAndPresetResDtoList.add(setQuestionResDto(question))
            }

        return allQuestionAndPresetResDtoList
    }

    override fun setQuestionResDto(question: Question): QuestionListResDto
    = convertResponseDto(question, presetService.findAllPresetByQuestionId(question.id))

}