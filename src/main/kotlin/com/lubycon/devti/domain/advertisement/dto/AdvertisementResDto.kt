package com.lubycon.devti.domain.advertisement.dto

import com.lubycon.devti.global.code.AdvertisementType
import java.time.LocalDate

data class AdvertisementResDto(

    private var id: Long,
    private var advertiser: String,
    private var title: String,
    private var imageUrl: String,
    private var advertisementStartDate: LocalDate,
    private var advertisementEndDate: LocalDate,
    private var advertisementType: AdvertisementType

)
