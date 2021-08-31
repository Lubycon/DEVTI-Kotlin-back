package com.lubycon.devti.domain.question.dto.response

import com.lubycon.devti.domain.preset.dto.response.PresetResDto
import com.lubycon.devti.domain.question.entity.Question
import com.lubycon.devti.global.code.AnswerType

fun convertResponseDto(question: Question, presetResDtoList: List<PresetResDto>) : QuestionListResDto{
    return QuestionListResDto(
        id = question.id,
        title = question.title,
        answerType = question.answerType,
        presetList = presetResDtoList
    )
}


data class QuestionListResDto(
    var id: Long,
    val title: String,
    val answerType: AnswerType,
    val presetList: List<PresetResDto>
)
