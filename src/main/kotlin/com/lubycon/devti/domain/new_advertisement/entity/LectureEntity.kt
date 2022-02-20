package com.lubycon.devti.domain.new_advertisement.entity

import com.lubycon.devti.domain.new_advertisement.dto.CreateLectureRequest
import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import javax.persistence.*

@Entity
@Table(name = "lecture")
class LectureEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val slogan: String,

    val platform: String,

    val url: String,

    val targetBias: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "lecture_id")
    val careers: List<CareerEntity> = ArrayList(),
) {
    constructor(createLectureRequest: CreateLectureRequest) : this(
        name = createLectureRequest.name,
        slogan = createLectureRequest.slogan,
        platform = createLectureRequest.platform,
        url = createLectureRequest.url,
        targetBias = createLectureRequest.targetBias,
        careers = createLectureRequest.careers.map { career -> CareerEntity(Career.FindCareerByValue.fromValue(career)!!) }
      
    )
}