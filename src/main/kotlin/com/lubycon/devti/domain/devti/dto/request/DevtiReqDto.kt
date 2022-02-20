package com.lubycon.devti.domain.devti.dto.request

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.lubycon.devti.domain.new_advertisement.entity.enum.Career
import com.lubycon.devti.global.code.BiasType
import io.swagger.annotations.ApiModelProperty


@JsonTypeName(value = "result")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
data class DevtiReqDto(

    @ApiModelProperty(value = "희망 직무 (F,B)", example = "F")
    val job: String,

    @ApiModelProperty(value = "연차 (NEWBIE(0년차), JUNIOR(1~3년차), SENIOR(3년차+))", example = "JUNIOR")
    val career: Career,

    @ApiModelProperty(value = "DEVTI 결과 HashMap String", example = "{W=90, A=60, P=60, V=35, T=40, S=75, L=0, C=15}")
    private val result: MutableMap<BiasType, Int>
) {
    @JsonAnyGetter
    fun getProperties(): Map<BiasType, Int> {
        return result
    }
}
