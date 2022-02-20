package com.lubycon.devti.domain.new_advertisement.entity

import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import javax.persistence.*

@Entity
@Table(name = "career")
class CareerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val career: Career,
)