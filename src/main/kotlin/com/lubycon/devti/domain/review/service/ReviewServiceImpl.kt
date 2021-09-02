package com.lubycon.devti.domain.review.service

import com.lubycon.devti.domain.review.dao.ReviewRepository
import com.lubycon.devti.domain.review.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewServiceImpl(
    private final val reviewRepository: ReviewRepository
): ReviewService {

    override fun findByReviewType(reviewType: String) = reviewRepository.findReviewByReviewType(reviewType)

}