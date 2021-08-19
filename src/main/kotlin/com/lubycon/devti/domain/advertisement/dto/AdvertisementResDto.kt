package com.lubycon.devti.domain.advertisement.dto

import com.lubycon.devti.domain.advertisement.entity.Advertisement
import com.lubycon.devti.global.code.AdvertisementType
import java.time.LocalDate

data class AdvertisementResDto(

    var id: Long,
    var advertiser: String,
    var title: String,
    var imageUrl: String,
    var advertisementStartDate: LocalDate,
    var advertisementEndDate: LocalDate,
    var advertisementType: AdvertisementType

)