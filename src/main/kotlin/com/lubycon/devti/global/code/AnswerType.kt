package com.lubycon.devti.global.code

enum class AnswerType(private val value: Int): DevtiEnumerable {
    PRESET(0),
    GAGE(1),
    INFO(2);

    override fun getValue(): Int {
        return value;
    }

    override fun getKey(): String {
        return name;
    }


}