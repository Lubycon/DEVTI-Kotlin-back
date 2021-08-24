package com.lubycon.devti.domain.bucket_test_type.service

import com.lubycon.devti.domain.bucket_test_type.dao.BucketTestTypeRepository
import com.lubycon.devti.domain.bucket_test_type.dto.response.BucketTestTypeGetResDto
import com.lubycon.devti.global.code.EntryPoint
import com.lubycon.devti.global.code.TestType
import org.springframework.stereotype.Service

@Service
class BucketTestTypeServiceImpl(
    private val bucketTestTypeRepository: BucketTestTypeRepository,
): BucketTestTypeService {

    override fun getBucketTestTypeAndCreateTraffic(entryPoint: EntryPoint): BucketTestTypeGetResDto {
        TODO("Not yet implemented")
    }

    override fun getNextTestType(entryPoint: EntryPoint): TestType {
        TODO("Not yet implemented")
    }
}