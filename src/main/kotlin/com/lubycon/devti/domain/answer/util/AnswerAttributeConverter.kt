package com.lubycon.devti.domain.answer.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import javax.persistence.AttributeConverter


private var objectMapper = ObjectMapper().configure(
    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
)


class AnswerAttributeConverter: AttributeConverter<List<AnswerAttribute>, String> {
    override fun convertToDatabaseColumn(answerAttributeList: List<AnswerAttribute>): String {
        return try {
            objectMapper.writeValueAsString(answerAttributeList)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException(answerAttributeList.toString())
        }

    }

    override fun convertToEntityAttribute(dbData: String): List<AnswerAttribute> {
        return try {
            objectMapper.readValue<List<AnswerAttribute>>(
                dbData,
                objectMapper.getTypeFactory().constructCollectionType(
                    MutableList::class.java,
                    AnswerAttribute::class.java
                )
            )
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException(dbData)
        }
    }
}