package com.lubycon.devti.domain.new_advertisement.repository

import com.lubycon.devti.domain.new_advertisement.entity.LectureEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureRepository : JpaRepository<LectureEntity, Long> {

    fun findAllByTargetBias(targetBias: String): List<LectureEntity>
    
}