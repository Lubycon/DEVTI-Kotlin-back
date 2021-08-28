package com.lubycon.devti.domain.bucket_test_type.service

import com.lubycon.devti.domain.bucket_test_type.dao.BucketTestTypeRepository
import com.lubycon.devti.domain.bucket_test_type.dto.response.BucketTestTypeGetResDto
import com.lubycon.devti.domain.traffic.entity.Traffic
import com.lubycon.devti.domain.traffic.service.TrafficService
import com.lubycon.devti.global.code.EntryPoint
import com.lubycon.devti.global.code.TestType
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {  }

@Service
class BucketTestTypeServiceImpl(
    private val bucketTestTypeRepository: BucketTestTypeRepository,
    private val trafficService: TrafficService
) : BucketTestTypeService {

    override fun getBucketTestTypeAndCreateTraffic(entryPoint: EntryPoint): BucketTestTypeGetResDto {

        logger.info { "Service Start" }
        val testType = getNextTestType(entryPoint)

        logger.info { "getNExtTestType 마치고 돌아와서 testType = $testType" }

        val newTraffic = Traffic(testType = testType)

        logger.info { "new Traffic = $newTraffic" }
        trafficService.saveTraffic(traffic = newTraffic)

        logger.info { "saveTraffic 마쳤음"}

        val bucketTestType = bucketTestTypeRepository.findByTestType(testType)
        logger.info { "findByTestType 결과 $bucketTestType" }
        logger.info { "@@@@bucketTestType = $bucketTestType"}
        return BucketTestTypeGetResDto(
            testType = bucketTestType.testType,
            phrases = bucketTestType.phrases
        )


    }

    override fun getNextTestType(entryPoint: EntryPoint): TestType {
        logger.info { "getNextTestType FUnction Start" }
        if (entryPoint.getValue().equals("mom")) return TestType.TYPE_COMMON_1
        logger.info { "if문 안거침" }
        val tmp =trafficService.getLastTraffic().testType.getNext()
        logger.info { "tmp = $tmp" }
        return tmp
    }
}