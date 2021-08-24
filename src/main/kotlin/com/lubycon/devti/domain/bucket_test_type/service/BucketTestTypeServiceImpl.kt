package com.lubycon.devti.domain.bucket_test_type.service

import com.lubycon.devti.domain.bucket_test_type.dao.BucketTestTypeRepository
import com.lubycon.devti.domain.bucket_test_type.dto.response.BucketTestTypeGetResDto
import com.lubycon.devti.domain.traffic.entity.Traffic
import com.lubycon.devti.domain.traffic.service.TrafficService
import com.lubycon.devti.global.code.EntryPoint
import com.lubycon.devti.global.code.TestType
import org.springframework.stereotype.Service

@Service
class BucketTestTypeServiceImpl(
    private val bucketTestTypeRepository: BucketTestTypeRepository,
    private val trafficService: TrafficService
) : BucketTestTypeService {

    override fun getBucketTestTypeAndCreateTraffic(entryPoint: EntryPoint): BucketTestTypeGetResDto {
        val testType = getNextTestType(entryPoint)
        val newTraffic = Traffic(testType = testType)
        trafficService.saveTraffic(traffic = newTraffic)

        val bucketTestType = bucketTestTypeRepository.findByTestType(testType)

        return BucketTestTypeGetResDto(
            testType = bucketTestType.testType,
            phrases = bucketTestType.phrases
        )


    }

    override fun getNextTestType(entryPoint: EntryPoint): TestType {
        if (entryPoint.getValue().equals("mom")) return TestType.TYPE_COMMON_1
        return trafficService.getLastTraffic().testType.getNext()
    }
}