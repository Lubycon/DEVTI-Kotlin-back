package com.lubycon.devti.domain.devti.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.lubycon.devti.domain.answer.entity.Answer
import javax.persistence.*


@Entity
class Devti(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "devti_id")
    private val id: Long = 0,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private val answer: Answer,

    @Column(name = "devti")
    private val devti: String,

    @Column(name = "devti_result")
    private val devtiResult: String
)