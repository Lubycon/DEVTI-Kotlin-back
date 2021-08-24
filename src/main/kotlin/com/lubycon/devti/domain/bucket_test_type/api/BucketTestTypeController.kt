package com.lubycon.devti.domain.bucket_test_type.api

import com.lubycon.devti.domain.bucket_test_type.dto.response.BucketTestTypeGetResDto
import com.lubycon.devti.domain.bucket_test_type.service.BucketTestTypeService
import com.lubycon.devti.global.code.EntryPoint
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/bucket-test-type")
@RestController
@Api(value = "BucketTestType")
class BucketTestTypeController(
    private val bucketTestTypeService: BucketTestTypeService
) {

    @GetMapping(value = ["/{entryPoint}"])
    @ApiOperation(value = "Bucket test 문구 가져오기")
    fun getBucketTestTypeAndCreateTraffic(@PathVariable entryPoint: EntryPoint)
            = ResponseEntity.ok(bucketTestTypeService.getBucketTestTypeAndCreateTraffic(entryPoint))

}