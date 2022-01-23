package com.lubycon.devti.domain.preset.dto.response

import com.lubycon.devti.global.code.BiasType

data class PresetResDto(
    val label: String?,
    val bias: BiasType,
    val weight: Float,
    val sequence: Long
)
