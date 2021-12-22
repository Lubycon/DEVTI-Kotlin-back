package com.lubycon.devti.domain.review.dao

import com.lubycon.devti.domain.review.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r where r.reviewType = :reviewType ")
    fun findReviewByReviewType(reviewType: String): List<Review>

    @Query("SELECT contents FROM Review where reviewType = :reviewType ")
    fun findContentsByReviewType(@Param("reviewType") reviewType: String) : List<String>
}