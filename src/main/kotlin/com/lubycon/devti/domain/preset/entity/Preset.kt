package com.lubycon.devti.domain.preset.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.lubycon.devti.domain.question.entity.Question
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Preset(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preset_id")
    private var id: Long = 0,

    @Column(name = "sequence")
    private val sequence: Long,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private val question: Question,

    @Column(length = 100)
    private val label: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "bias")
    private val bias: BiasType,

    @Column(name = "weight")
    private val weight: Float
): BaseTimeEntity()