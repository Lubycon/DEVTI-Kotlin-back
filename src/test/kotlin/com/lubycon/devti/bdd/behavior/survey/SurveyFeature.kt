package com.lubycon.devti.bdd.behavior.survey

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.survey.dao.SurveyRepository
import com.lubycon.devti.domain.survey.dto.SurveyPostReqDto
import com.lubycon.devti.domain.survey.service.SurveyService
import com.lubycon.devti.global.code.SurveyType
import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.error.exception.InvalidValueException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [SpringDataConfig::class])
class SurveyFeature(
    _surveyRepository: SurveyRepository
) : BehaviorSpec() {

    private val surveyRepository = spyk(_surveyRepository)
    private val surveyService = SurveyService(surveyRepository)

    lateinit var surveyPostReqDto: SurveyPostReqDto


    init {
        Given("사전신청 하기") {
            When("사용자로부터 입력받았을 때") {
                And("기존에 이력 없는 핸드폰 번호 입력 받았을 경우") {
                    surveyPostReqDto = SurveyPostReqDto(
                        surveyType = SurveyType.DEVTI,
                        testType = TestType.TYPE_COMMON_1,
                        phone = "091-9639-4674"
                    )
                    val result = surveyService.createSurvey(surveyPostReqDto)
                    Then("정상적으로 사전신천 완료") {
                        result.phone.shouldBe(surveyPostReqDto.phone)

//                        verify(exactly = 1) {
//                            surveyService.isFilledWithPhoneSurvey(any())
//                            surveyService.checkDuplicatedSurveyByPhone(any())
//                            surveyRepository.save(any())
//                        }
//                    }
//                    And("기존 신청한 핸드폰 번호 입력 받았을 경우") {
//                        Then("중복발생") {
//                            val exception = shouldThrow<InvalidValueException>() {
//                                surveyService.createSurvey(surveyPostReqDto)
//                            }
//                        }
//                    }
//                    And("기존 신청한 핸드폰 번호 입력 받았을 경우2") {
//                        surveyService.createSurvey(surveyPostReqDto)
//                        Then("중복발생") {
//                            shouldThrow<InvalidValueException> {
//
//                            }
//
//                        }
//                    }


                    }
                }
            }

        }
    }
}


