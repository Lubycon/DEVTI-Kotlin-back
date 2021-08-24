package com.lubycon.devti.domain.bucket_test_type.service

import com.lubycon.devti.domain.bucket_test_type.dto.response.BucketTestTypeGetResDto
import com.lubycon.devti.global.code.EntryPoint
import com.lubycon.devti.global.code.TestType
import org.springframework.stereotype.Component

@Component
interface BucketTestTypeService {
    fun getBucketTestTypeAndCreateTraffic(entryPoint: EntryPoint): BucketTestTypeGetResDto
    fun getNextTestType(entryPoint: EntryPoint): TestType
}