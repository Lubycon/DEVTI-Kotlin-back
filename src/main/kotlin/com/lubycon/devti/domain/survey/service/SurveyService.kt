package com.lubycon.devti.domain.survey.service

import com.lubycon.devti.domain.survey.dao.SurveyRepository
import com.lubycon.devti.domain.survey.dto.SurveyPostReqDto
import com.lubycon.devti.domain.survey.dto.SurveyPostResDto
import com.lubycon.devti.domain.survey.entity.Survey
import com.lubycon.devti.global.error.ErrorCode
import com.lubycon.devti.global.error.exception.InvalidValueException

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

val logger = KotlinLogging.logger {  }

@Service
class SurveyService(
//    @Value("\${constant.slack.survey-monitoring-channel-url}")
//    private val slackSurveyMonitoringChannelUrl: String,
//    @Value("\${constant.slack.survey-monitoring-channel-name}")
//    private val slackSurveyMonitoringChannelName: String,
    private val surveyRepository: SurveyRepository
) {

    @Transactional
    fun createSurvey(surveyPostReqDto: SurveyPostReqDto): SurveyPostResDto {
        logger.info { "service start" }

        if (isFilledWithPhoneSurvey(surveyPostReqDto)) {
            checkDuplicatedSurveyByPhone(surveyPostReqDto.phone!!)
        } else {
            checkDuplicatedSurveyByEmail(surveyPostReqDto.email!!)
        }

        val survey = Survey(
            comment = surveyPostReqDto.comment,
            surveyType = surveyPostReqDto.surveyType,
            email = surveyPostReqDto.email,
            phone = surveyPostReqDto.phone,
            testType = surveyPostReqDto.testType
        )

        logger.info { "${survey} " }

        return surveyRepository.save(survey).toResDto()
    }

    fun isFilledWithPhoneSurvey(surveyPostReqDto: SurveyPostReqDto): Boolean {
        return surveyPostReqDto.phone != null
    }

    fun checkDuplicatedSurveyByPhone(phone: String) {
        if (surveyRepository.findByPhone(phone) != null) {
            logger.info{ " error exception !!!"}
            throw InvalidValueException(ErrorCode.PHONE_DUPLICATION)
        }
    }

    fun checkDuplicatedSurveyByEmail(email: String) {
        if (surveyRepository.findByEmail(email) != null) {
            throw InvalidValueException(ErrorCode.EMAIL_DUPLICATION)
        }
    }
//
//    private fun pushMessage(registeredSurvey: Survey){
//        val slackPusher = SlackPusher(slackSurveyMonitoringChannelUrl,
//        "#" + slackSurveyMonitoringChannelName)
//
//        slackPusher.pushMessage(
//            "*신규 사전 참여 신청이 들어왔습니다!*"
//                    + "\n- Comment : " + registeredSurvey.comment
//                    + "\n- Test Type: " + registeredSurvey.testType
//        )
//
//    }


}