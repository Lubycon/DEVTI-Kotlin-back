package com.lubycon.devti.global.error

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.validation.BindingResult
import java.util.function.Function
import java.util.stream.Collectors

data class ErrorResponse(
    @field:JsonProperty("status")
    private var status: Int,

    @field:JsonProperty("message")
    private var message: String,

    @field:JsonProperty("code")
    private var code: String
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message, errorCode.code)
}