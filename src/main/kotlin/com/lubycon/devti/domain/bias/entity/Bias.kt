package com.lubycon.devti.domain.bias.entity

import com.lubycon.devti.global.code.BiasType
import com.lubycon.devti.global.code.Pillar
import javax.persistence.*

@Entity
class Bias(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bias_id")
    private val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "pillar")
    private val pillar: Pillar,

    @Enumerated(EnumType.STRING)
    @Column(name = "bias")
    private val bias: BiasType,

    @Column(name = "kr_bias")
    private val krBias: String,

    @Column(name = "en_bias")
    private val enBias: String

)