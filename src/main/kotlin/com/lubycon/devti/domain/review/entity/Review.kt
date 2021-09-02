package com.lubycon.devti.domain.review.entity

import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import javax.persistence.*

@Entity
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private val id: Long,


    @Lob
    @Column(length = 500)
    val headline: String,

    @Lob
    @Column(length = 500)
    private val title: String,

    @Lob
    @Column(length = 500)
    private val contents: String,

    private val reviewType: String

){
    companion object {
        fun toResDto(review: Review): ReviewResDto {
            return review.run {
                ReviewResDto(title = review.title, contents = review.contents)
            }
        }
    }
}