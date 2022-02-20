package com.lubycon.devti.domain.new_advertisement.entity

import javax.persistence.*

@Entity
@Table(name = "lecture")
class LectureEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val slogan: String,

    val paltform: String,

    val url: String,

    val targetBias: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "lecture_id")
    val careers: List<CareerEntity> = ArrayList(),
)