package com.lubycon.devti.domain.bucket_test_type.dto.response

import com.lubycon.devti.global.code.TestType

data class BucketTestTypeGetResDto(
    val testType: TestType,
    val phrases: String
)
