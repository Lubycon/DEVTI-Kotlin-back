package com.lubycon.devti.domain.preset.service

import com.lubycon.devti.domain.preset.dto.response.PresetResDto
import org.springframework.stereotype.Component

@Component
interface PresetService {
    fun findAllPresetByQuestionId(questionId: Long): List<PresetResDto>
}