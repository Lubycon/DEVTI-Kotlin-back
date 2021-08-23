package com.lubycon.devti.global.error

import com.lubycon.devti.global.error.exception.InvalidValueException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice



@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [RuntimeException::class])    //Runtime Error 터지면 아무거나 다잡음 -> 지정하지 않았는데 처리 되었음 -> Advice 명시 해주거나, 정말 표준적인 것만 처리
    fun exception(e: RuntimeException): String {
        return "Server Error 입니당~"
    }

    @ExceptionHandler(InvalidValueException::class)
    fun handleEntityNotFoundException(ex: InvalidValueException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(ex.errorCode)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

}