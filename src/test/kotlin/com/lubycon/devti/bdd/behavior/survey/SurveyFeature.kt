package com.lubycon.devti.bdd.behavior.survey

import com.lubycon.devti.domain.survey.dao.SurveyRepository
import com.lubycon.devti.domain.survey.dto.SurveyPostReqDto
import com.lubycon.devti.domain.survey.service.SurveyService
import com.lubycon.devti.global.code.SurveyType
import com.lubycon.devti.global.code.TestType
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class SurveyFeature(
    private val surveyService: SurveyService,
    private val surveyRepository: SurveyRepository
): BehaviorSpec() {


    init{
        Given("사전신청 하기") {
            When("사용자로부터 입력받았을 때") {

                And("기존에 없는 핸드폰 번호 입력 받았을 경우") {
                    val surveyPostReqDto = SurveyPostReqDto(
                        surveyType = SurveyType.DEVTI,
                        testType = TestType.TYPE_COMMON_1,
                        phone = "010-9639-4624"
                    )
                    val result = surveyService.createSurvey(surveyPostReqDto)
                    Then("정상적으로 사전신천 완료") {
                        result.phone.shouldBe(surveyPostReqDto.phone)

//                        verify(exactly = 1) {
//                            surveyService.isFilledWithPhoneSurvey(any())
//                            surveyService.checkDuplicatedSurveyByPhone(any()
//                            )
//                            surveyRepository.save(any())
//                        }

                    }
                }
            }

        }
    }


}