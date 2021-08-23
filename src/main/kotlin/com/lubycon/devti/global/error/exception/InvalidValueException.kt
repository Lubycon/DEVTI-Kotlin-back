package com.lubycon.devti.global.error.exception

import com.lubycon.devti.global.error.ErrorCode

class InvalidValueException(
    val errorCode: ErrorCode
): RuntimeException()