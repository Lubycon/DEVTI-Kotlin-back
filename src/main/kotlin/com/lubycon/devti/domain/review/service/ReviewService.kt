package com.lubycon.devti.domain.review.service

import com.lubycon.devti.domain.review.dao.ReviewRepository
import com.lubycon.devti.domain.review.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository
) {

    fun findByReviewType(reviewType: String) = reviewRepository.findReviewByReviewType(reviewType)

    fun findContentsByReviewType(reviewType: String) = reviewRepository.findContentsByReviewType(reviewType)

}