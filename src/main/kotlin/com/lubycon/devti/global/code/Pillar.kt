package com.lubycon.devti.global.code

import com.lubycon.devti.global.code.BiasType

enum class Pillar(
    private val pillar: String,
    val biasList: List<BiasType>
) {

    ROLE("직군", listOf(BiasType.V, BiasType.A)),
    SCALE("규모", listOf(BiasType.S, BiasType.C)),
    INTEREST("관심사", listOf(BiasType.P, BiasType.T)),
    PRIORITY("우선순위", listOf(BiasType.W, BiasType.L)),
    REFERENCE("참고정보", listOf(BiasType.J, BiasType.Y));

}