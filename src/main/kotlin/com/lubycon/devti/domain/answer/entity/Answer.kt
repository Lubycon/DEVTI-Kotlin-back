package com.lubycon.devti.domain.answer.entity

import com.lubycon.devti.domain.answer.util.AnswerAttributeConverter
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private val id: Long = 0,

    @Lob
    @Convert(converter = AnswerAttributeConverter::class)
    @Column(name = "answer_list")
    private val answerList: List<AnswerAttribute>


):BaseTimeEntity() {
}