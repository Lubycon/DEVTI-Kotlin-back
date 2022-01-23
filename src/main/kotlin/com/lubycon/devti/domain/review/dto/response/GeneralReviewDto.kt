package com.lubycon.devti.domain.review.dto.response

data class GeneralReviewDto(
    val result: String,
    val title: String,
    val content: String,
    val summaryReview: List<String>
)
