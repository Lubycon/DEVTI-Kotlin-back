package com.lubycon.devti.domain.answer.dao

import com.lubycon.devti.domain.answer.entity.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long> {
}