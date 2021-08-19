package com.lubycon.devti.global.code

enum class AdvertisementType(private val value: Int) : DevtiEnumerable {
    ALL(0) ,
    LECTURE(1),
    RECRUIT(2),
    ETC(999);

    override fun getValue(): Int {
        return value
    }

    override fun getKey(): String {
        return name
    }


}