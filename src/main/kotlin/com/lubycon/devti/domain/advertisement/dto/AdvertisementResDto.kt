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

){
    fun convertResponseDto(advertisement: Advertisement): AdvertisementResDto {
        return AdvertisementResDto(
            id = advertisement.id,
            advertiser = advertisement.advertiser,
            title = advertisement.title,
            imageUrl = advertisement.imageUrl,
            advertisementStartDate = advertisement.advertisementStartDate,
            advertisementEndDate = advertisement.advertisementEndDate,
            advertisementType = advertisement.advertisementType
        )

    }
}
