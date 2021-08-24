package com.lubycon.devti.domain.traffic.entity

import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.entity.BaseTimeEntity
import lombok.Getter
import javax.persistence.*

@Entity
class Traffic(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAFFIC_ID")
    private val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    val testType: TestType

): BaseTimeEntity()