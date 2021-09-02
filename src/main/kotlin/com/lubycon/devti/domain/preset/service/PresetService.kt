package com.lubycon.devti.domain.preset.service

import com.lubycon.devti.domain.preset.dao.PresetRepository
import com.lubycon.devti.domain.preset.dto.response.PresetResDto
import org.springframework.stereotype.Service

@Service
class PresetService(
    private val presetRepository: PresetRepository
) {

    fun findAllPresetByQuestionId(questionId: Long): List<PresetResDto> {
        val presetList = presetRepository.findAllByQuestionId(questionId)
        val presetResDtoList = mutableListOf<PresetResDto>()

        presetList.stream().forEach { preset ->
            presetResDtoList.add(preset.toResDto())
        }

        return presetResDtoList
    }
}