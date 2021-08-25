package com.lubycon.devti.bdd.behavior.survey

import com.lubycon.devti.SpringDataConfig
import com.lubycon.devti.domain.survey.dao.SurveyRepository
import com.lubycon.devti.domain.survey.dto.SurveyPostReqDto
import com.lubycon.devti.domain.survey.service.SurveyService
import com.lubycon.devti.global.code.SurveyType
import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.error.ErrorCode
import com.lubycon.devti.global.error.exception.InvalidValueException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.spyk
import io.mockk.verify
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [SpringDataConfig::class])
class SurveyFeature(
    _surveyRepository: SurveyRepository,
) : BehaviorSpec() {

    private val surveyRepository = spyk(_surveyRepository)
    private val _surveyService = SurveyService(surveyRepository)
    private val surveyService = spyk(_surveyService)

    lateinit var surveyPostReqDto: SurveyPostReqDto

    override fun afterEach(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init {
        Given("사전신청 하기") {
            When("사용자로부터 입력받았을 때") {

                And("기존에 이력 없는 핸드폰 번호로 사전신청 받았을 경우") {
                    surveyPostReqDto = SurveyPostReqDto(
                        surveyType = SurveyType.DEVTI,
                        testType = TestType.TYPE_COMMON_1,
                        phone = "091-9639-4674"
                    )
                    val result = surveyService.createSurvey(surveyPostReqDto)
                    Then("정상적으로 사전신천 완료") {
                        result.phone.shouldBe(surveyPostReqDto.phone)
                        result.email.shouldBe(null)
                        verify(exactly = 1) {
                            surveyService.isFilledWithPhoneSurvey(any())
                            surveyService.checkDuplicatedSurveyByPhone(any())
                            surveyRepository.save(any())
                        }
                        verify(exactly = 0) {
                            surveyService.checkDuplicatedSurveyByEmail(any())
                        }
                    }
                }

                And("기존 신청한 핸드폰 번호로 사전신천 받았을 경우") {
                    Then("중복발생 InvalidValueException") {
                        val exception = shouldThrow<InvalidValueException>() {
                            surveyService.createSurvey(surveyPostReqDto)
                        }
                        verify(exactly = 1) {
                            surveyService.isFilledWithPhoneSurvey(any())
                            surveyService.checkDuplicatedSurveyByPhone(any())
                            InvalidValueException(ErrorCode.PHONE_DUPLICATION)
                        }
                        verify(exactly = 0) {
                            surveyService.checkDuplicatedSurveyByEmail(any())
                            surveyRepository.save(any())
                        }
                    }
                }

                And("기존에 이력 없는 이메일로 사전신청 받았을 경우") {
                    surveyPostReqDto = SurveyPostReqDto(
                        surveyType = SurveyType.DEVTI,
                        testType = TestType.TYPE_COMMON_1,
                        email = "guddnjs2495@naver.com"
                    )
                    val result = surveyService.createSurvey(surveyPostReqDto)
                    Then("정상적으로 사전신천 완료") {
                        result.email.shouldBe(surveyPostReqDto.email)
                        result.phone.shouldBe(null)
                        verify(exactly = 1) {
                            surveyService.isFilledWithPhoneSurvey(any())
                            surveyService.checkDuplicatedSurveyByEmail(any())
                            surveyRepository.save(any())
                        }
                        verify(exactly = 0) {
                            surveyService.checkDuplicatedSurveyByPhone(any())
                        }
                    }
                }

                And("기존 신청한 이메일로 사전신천 받았을 경우") {
                    Then("중복발생 InvalidValueException") {
                        val exception = shouldThrow<InvalidValueException>() {
                            surveyService.createSurvey(surveyPostReqDto)
                        }
                        verify(exactly = 1) {
                            surveyService.isFilledWithPhoneSurvey(any())
                            surveyService.checkDuplicatedSurveyByEmail(any())
                            InvalidValueException(ErrorCode.EMAIL_DUPLICATION)
                        }
                        verify(exactly = 0) {
                            surveyService.checkDuplicatedSurveyByPhone(any())
                            surveyRepository.save(any())
                        }
                    }
                }

            }
        }
    }

}




