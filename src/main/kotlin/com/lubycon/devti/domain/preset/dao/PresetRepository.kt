package com.lubycon.devti.domain.preset.dao

import com.lubycon.devti.domain.preset.entity.Preset
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PresetRepository: JpaRepository<Preset, Long>{

    fun findAllByQuestionId(questionId: Long): List<Preset>
}