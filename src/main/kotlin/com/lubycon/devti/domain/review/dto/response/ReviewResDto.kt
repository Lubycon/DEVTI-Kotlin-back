package com.lubycon.devti.domain.review.dto.response

import javax.persistence.Column
import javax.persistence.Lob

data class ReviewResDto(

    @Column(length = 500)
    val title: String?,
    val contents: String,

)
