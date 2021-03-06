package com.lubycon.devti.domain.answer.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lubycon.devti.domain.answer.entity.AnswerAttribute
import javax.persistence.AttributeConverter


private var objectMapper = ObjectMapper().configure(
    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
)


class AnswerAttributeConverter: AttributeConverter<List<AnswerAttribute>, String> {

    private val gson = Gson()

    override fun convertToDatabaseColumn(answerAttributeList: List<AnswerAttribute>?): String {
        return try {
            return gson.toJson(answerAttributeList)
        } catch (e: JsonProcessingException) {
            throw IllegalArgumentException(answerAttributeList.toString())
        }

    }

//    override fun convertToEntityAttribute(dbData: String?): List<AnswerAttribute> {
//        return try {
//            objectMapper.readValue(
//                dbData,
//                objectMapper.typeFactory.constructCollectionType(
//                    MutableList::class.java,
//                    AnswerAttribute::class.java
//                )
//            )
//        } catch (e: JsonProcessingException) {
//            throw IllegalArgumentException(dbData)
//        }
//    }

    override fun convertToEntityAttribute(dbData: String?): MutableList<AnswerAttribute>? {
        if (dbData == null)
            return null

        val collectionType = object : TypeToken<MutableList<AnswerAttribute>>() {}.type

        return gson.fromJson(dbData, collectionType)
    }

}