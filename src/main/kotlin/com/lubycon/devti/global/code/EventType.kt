package com.lubycon.devti.global.code

import com.lubycon.devti.global.code.DevtiEnumerable

enum class EventType(
    private var value: Int
): DevtiEnumerable {

    CLICK_CTA_BUTTON(0),
    CLICK_SHARE_BUTTON(1),;


    override fun getValue(): Int {
        return value
    }

    override fun getKey(): String {
        return name
    }

}