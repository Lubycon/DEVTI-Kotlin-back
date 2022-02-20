package com.lubycon.devti.domain.new_advertisement.entity

import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import javax.persistence.*

@Entity
@Table(name = "career")
class CareerEntity(

    val career: Career,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
)