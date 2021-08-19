package com.lubycon.devti.global.code

import com.lubycon.devti.global.code.DevtiEnumerable

enum class SurveyType(
    private val value: Int
): DevtiEnumerable {
    DEVTI(0);

    override fun getKey(): String {
        return name
    }

    override fun getValue(): Int {
        return value
    }

}