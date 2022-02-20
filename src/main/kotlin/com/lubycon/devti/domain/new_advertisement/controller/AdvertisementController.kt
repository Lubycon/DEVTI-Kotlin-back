package com.lubycon.devti.domain.new_advertisement.controller

import com.lubycon.devti.domain.new_advertisement.dto.CreateLectureRequest
import com.lubycon.devti.domain.new_advertisement.entity.LectureEntity
import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import com.lubycon.devti.domain.new_advertisement.service.AdvertisementService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advertisements")
@Api(value = "Advertisement")
class AdvertisementController(
    private val advertisementService: AdvertisementService
) {

    @PostMapping
    fun createLecture(
        @RequestBody createLectureRequest: CreateLectureRequest
    ) {
        advertisementService.createLecture(createLectureRequest)
    }

    @GetMapping
    fun getLecture(
        targetBias: String, career: Career
    ): List<LectureEntity> {
        return advertisementService.getLecture(targetBias, career)
    }


}