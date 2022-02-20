package com.lubycon.devti.domain.new_advertisement.service

import com.lubycon.devti.domain.new_advertisement.dto.CreateLectureRequest
import com.lubycon.devti.domain.new_advertisement.entity.LectureEntity
import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import com.lubycon.devti.domain.new_advertisement.repository.LectureRepository
import org.springframework.stereotype.Service

@Service
class AdvertisementService(
    private val lectureRepository: LectureRepository
) {

    fun createLecture(createLectureRequest: CreateLectureRequest) {
        lectureRepository.save(LectureEntity(createLectureRequest))
    }

    fun getLecture(targetBias: String, career: Career): List<LectureEntity> {

        val lectureEntityList: MutableList<LectureEntity> = ArrayList()

        for (data in lectureRepository.findAllByTargetBias(targetBias)) {
            val checkList = data.careers.filter { careerEntity -> careerEntity.career == career }
            if (!checkList.isEmpty()) {
                lectureEntityList.add(data)
            }
        }

        return lectureEntityList
    }
}