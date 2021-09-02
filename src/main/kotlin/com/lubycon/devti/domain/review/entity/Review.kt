package com.lubycon.devti.domain.review.entity

import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import javax.persistence.*

@Entity
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private val id: Long,

    @Lob
    @Column(length = 500)
    private val headLine: String,

    @Lob
    @Column(length = 500)
    private val title: String,

    @Lob
    @Column(length = 500)
    private val contents: String,

    private val reviewType: String

){
    fun toResDto(review: Review): ReviewResDto {
        return ReviewResDto(
            title = title,
            contents = contents
        )
    }
}