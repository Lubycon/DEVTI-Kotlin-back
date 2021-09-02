package com.lubycon.devti.domain.review.service

import com.lubycon.devti.domain.review.entity.Review
import org.springframework.stereotype.Component

@Component
interface ReviewService {
    fun findByReviewType(reviewType: String): Review
}