package com.lubycon.devti.global.error.exception

import com.lubycon.devti.global.error.ErrorCode

class EntityNotFoundException(
    val errorCode: ErrorCode
): RuntimeException()
