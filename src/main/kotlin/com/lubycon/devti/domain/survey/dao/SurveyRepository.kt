package com.lubycon.devti.domain.survey.dao

import com.lubycon.devti.domain.survey.entity.Survey
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyRepository: JpaRepository<Survey, Long> {

    fun findByPhone(phone: String): Survey ?= null

    fun findByEmail(mail: String): Survey ?= null
}