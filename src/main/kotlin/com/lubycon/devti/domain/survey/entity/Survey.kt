package com.lubycon.devti.domain.survey.entity


import com.lubycon.devti.domain.survey.dto.SurveyPostResDto
import com.lubycon.devti.global.code.SurveyType
import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class Survey(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private var id: Long = 0,

    @Column(length = 500)
    private var comment: String ?= null,

    @Enumerated(EnumType.STRING)
    private var surveyType: SurveyType,

    @Column(length = 100, unique = true)
    private var email: String ?= null,

    @Column(length = 50, unique = true)
    private var phone: String ?= null,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    private var testType: TestType

): BaseTimeEntity() {

    fun toResDto(): SurveyPostResDto {
        return SurveyPostResDto(
            id = id,
            comment = comment,
            email = email,
            phone = phone,
            testType = testType
        )
    }
}