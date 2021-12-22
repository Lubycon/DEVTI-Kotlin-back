package com.lubycon.devti.global.code

enum class BiasType(private val value: String) {
    V("V"),
    A("A"),
    S("S"),
    C("C"),
    P("P"),
    T("T"),
    W("W"),
    L("L"),
    J("J"),
    Y("Y");

    fun getValue(): String{
        return value
    }

    fun getKey(): String {
        return name
    }

}