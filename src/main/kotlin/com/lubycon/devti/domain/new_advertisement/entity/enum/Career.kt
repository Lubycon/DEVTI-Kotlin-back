package com.lubycon.devti.domain.new_advertisement.entity.enum

enum class Career(val value: Int) {
    NEWBIE(0),
    JUNIOR(1),
    SENIOR(2);

    object FindCareerByValue {
        private val map = Career.values().associateBy(Career::value)
        fun fromValue(value: Int) = map[value]
    }


}
