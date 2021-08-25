package com.lubycon.devti.bdd.behavior.bucket_test_type

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.bucket_test_type.dao.BucketTestTypeRepository
import com.lubycon.devti.domain.bucket_test_type.service.BucketTestTypeService
import com.lubycon.devti.domain.bucket_test_type.service.BucketTestTypeServiceImpl
import com.lubycon.devti.domain.traffic.dao.TrafficRepository
import com.lubycon.devti.domain.traffic.service.TrafficServiceImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.mockk.clearAllMocks
import io.mockk.spyk
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [SpringDataConfig::class])
class BucketTestTypeFeature(
    _bucketTestTypeRepository: BucketTestTypeRepository,
    _trafficRepository: TrafficRepository
): BehaviorSpec() {

    private val trafficRepository = spyk(_trafficRepository)
    private val _trafficService = TrafficServiceImpl(trafficRepository)
    private val trafficService = spyk(_trafficService)

    private val bucketTestTypeRepository = spyk(_bucketTestTypeRepository)
    private val _bucketTestTypeService = BucketTestTypeServiceImpl(bucketTestTypeRepository, trafficService)
    private val bucketTestTypeService = spyk(_bucketTestTypeService)


    override fun afterEach(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init {
        Given("test1") {
            When("entryPoint = mom") {

            }
        }
    }




}