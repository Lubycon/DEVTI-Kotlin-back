package com.lubycon.devti.domain.question.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.lubycon.devti.domain.preset.entity.Preset
import com.lubycon.devti.global.code.AnswerType
import com.lubycon.devti.global.code.Pillar
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Question(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    val id: Long = 0,

    @Column(name = "title", length = 100)
    val title: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "pillar")
    val pillar: Pillar,

    @Enumerated(EnumType.STRING)
    @Column(name = "answer_type")
    val answerType: AnswerType,

    @JsonManagedReference
    @OneToMany(mappedBy = "label", cascade = [CascadeType.ALL], orphanRemoval = true)
    val labels: Set<Preset> = HashSet<Preset>()

): BaseTimeEntity()