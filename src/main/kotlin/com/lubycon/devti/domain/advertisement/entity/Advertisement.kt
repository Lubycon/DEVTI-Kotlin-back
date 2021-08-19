package com.lubycon.devti.domain.advertisement.entity


import com.lubycon.devti.global.code.AdvertisementType
import com.lubycon.devti.global.entity.BaseTimeEntity
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto
import java.time.LocalDate
import javax.persistence.*

@Entity
class Advertisement (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private val id: Long = 0,

    @Column(name = "advertiser")
    private val advertiser: String,

    @Column(name = "title")
    private val title: String,

    @Column(name = "imageUrl")
    private val imageUrl: String,

    @Column(name = "advertisement_start_date")
    private val advertisementStartDate: LocalDate,

    @Column(name = "advertisement_end_date")
    private val advertisementEndDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "advertisement_type", insertable = false, updatable = false)
    private val advertisementType: AdvertisementType

): BaseTimeEntity() {

    fun toResDto(): AdvertisementResDto {
        return AdvertisementResDto(
            id = id,
            advertiser = advertiser,
            title = title,
            imageUrl = imageUrl,
            advertisementStartDate = advertisementStartDate,
            advertisementEndDate = advertisementEndDate,
            advertisementType = advertisementType
        )
    }
}