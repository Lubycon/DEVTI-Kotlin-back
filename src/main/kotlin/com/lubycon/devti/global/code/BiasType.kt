package com.lubycon.devti.global.code

enum class BiasType(private val value: Int) : DevtiEnumerable {
    V(0),
    A(1),
    S(2),
    C(3),
    P(4),
    T(5),
    W(6),
    L(7),
    J(8),
    Y(9);

    override fun getValue(): Int {
        return value
    }

    override fun getKey(): String {
        return name
    }

}