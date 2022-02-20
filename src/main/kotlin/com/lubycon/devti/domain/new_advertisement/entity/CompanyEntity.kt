package com.lubycon.devti.domain.new_advertisement.entity

import com.lubycon.devti.domain.new_advertisement.entity.enum.Job
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class CompanyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val slogan: String,

    val jobName: Job,

    val company: String,

    val scale: SCALE,

    val url: String,
)