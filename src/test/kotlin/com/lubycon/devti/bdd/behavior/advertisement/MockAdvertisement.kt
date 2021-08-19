package com.lubycon.devti.bdd.behavior.advertisement

import com.lubycon.devti.domain.advertisement.entity.Advertisement
import com.lubycon.devti.global.code.AdvertisementType
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import java.time.LocalDate

object MockAdvertisement {

    fun advertisement(advertisementType: AdvertisementType) = Advertisement(
        id = Arb.long(min=1).single(),
        advertiser = Arb.string(5..10).single(),
        title = "testTitle" + Arb.int(1..1000).single(),
        imageUrl = Arb.stringPattern("([a-zA-Z0-9]{1,10})\\.com").single(),
        advertisementStartDate = LocalDate.now().minusDays(7),
        advertisementEndDate = LocalDate.now().plusDays(7),
        advertisementType = advertisementType
    )
}