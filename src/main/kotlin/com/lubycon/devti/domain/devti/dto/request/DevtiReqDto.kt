package com.lubycon.devti.domain.devti.dto.request

import io.swagger.annotations.ApiModelProperty

data class DevtiReqDto(

    @ApiModelProperty(value = "희망 직무 (F,B)", example = "F")
    val job: String,

    @ApiModelProperty(value = "DEVTI 결과 HashMap String", example = "{W=90, A=60, P=60, V=35, T=40, S=75, L=0, C=15}")
    val result: String

)
