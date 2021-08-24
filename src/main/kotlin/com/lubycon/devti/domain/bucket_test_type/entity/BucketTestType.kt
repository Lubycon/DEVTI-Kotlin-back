package com.lubycon.devti.domain.bucket_test_type.entity

import com.lubycon.devti.global.code.TestType
import com.lubycon.devti.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
class BucketTestType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUCKET_TEST_TYPE_ID")
    private val id: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "test_type")
    private val testType: TestType,

    @Column(name = "description")
    private val description: String ?= null,

    @Column(name = "phrases")
    private val phrases: String

): BaseTimeEntity() {
}