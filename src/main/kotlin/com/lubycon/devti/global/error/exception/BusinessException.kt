package com.lubycon.devti.global.error.exception

import com.lubycon.devti.global.error.ErrorCode


open class BusinessException(
    val errorCode: ErrorCode, message: String?
): RuntimeException(message) {

}


