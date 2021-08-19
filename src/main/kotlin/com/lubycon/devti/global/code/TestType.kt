package com.lubycon.devti.global.code

val testTypes: Array<TestType> = TestType.values()

enum class TestType(
    private val value: Int
): DevtiEnumerable {

    TYPE_COMMON_1(0), //Common type 1
    TYPE_COMMON_2(1), //Common type 2
    TYPE_COMMON_3(2), //Common type 3
    TYPE_COMMON_4(3), //Common type 4
    TYPE_MOM_CAFE_1(4), //Mom cafe type
    ;


    override fun getValue(): Int {
        return value
    }

    override fun getKey(): String {
        return name
    }

    fun getNext(): TestType {
        if((this.ordinal + 1) % testTypes.size == testTypes.size - 1) {
            return testTypes[0]
        }

        return testTypes[(this.ordinal + 1) % testTypes.size]
    }

}