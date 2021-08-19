package com.lubycon.devti.global.code

enum class EntryPoint(
    private val value: String
) {
    COMMON_ENTRY_POINT("common"), //Common type 1
    MOM_ENTRY_POINT("mom"), //Common type 2
    ;

    fun getValue(): String {
        return value
    }

    fun getKey(): String{
        return name
    }

}