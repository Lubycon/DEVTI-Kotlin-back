package com.lubycon.devti.domain.bias

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar

object MockBiasListNotInReference {

    var bias_V = Bias(
        id = 1,
        bias = BiasType.V,
        enBias = "Visualization",
        krBias = "시각화",
        pillar = Pillar.ROLE
        )

    var bias_A = Bias(
        id = 2,
        bias = BiasType.A,
        enBias = "Architecture",
        krBias = "설계",
        pillar = Pillar.ROLE
    )

    var bias_S = Bias(
        id = 3,
        bias = BiasType.S,
        enBias ="StartUp",
        krBias = "스타트업",
        pillar = Pillar.SCALE
    )

    var bias_C = Bias(
        id = 4,
        bias = BiasType.C,
        enBias = "Corporation",
        krBias = "대기업",
        pillar = Pillar.SCALE
    )

    var bias_P = Bias(
        id = 5,
        bias = BiasType.P,
        enBias = "Product",
        krBias = "상품",
        pillar = Pillar.INTEREST
    )

    var bias_T = Bias(
        id = 6,
        bias = BiasType.T,
        enBias = "Technology",
        krBias = "기술",
        pillar = Pillar.INTEREST
    )

    var bias_W = Bias(
        id = 7,
        bias = BiasType.W,
        enBias = "Work",
        krBias = "업무",
        pillar = Pillar.PRIORITY
    )

    var bias_L = Bias(
        id = 8,
        bias = BiasType.L,
        enBias = "Life",
        krBias = "개인시간",
        pillar = Pillar.PRIORITY
    )


    val biasList = listOf(bias_V, bias_A, bias_S, bias_C, bias_P, bias_T, bias_W, bias_L)





}