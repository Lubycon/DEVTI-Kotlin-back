package com.lubycon.devti.domain.review.dao

import com.lubycon.devti.domain.review.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: JpaRepository<Review, Long> {
    fun findReviewByReviewType(reviewType: String): Review
}