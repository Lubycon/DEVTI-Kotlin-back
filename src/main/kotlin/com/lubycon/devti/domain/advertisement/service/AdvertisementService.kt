package com.lubycon.devti.domain.advertisement.service

import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto
import com.lubycon.devti.global.code.AdvertisementType
import com.lubycon.devti.domain.advertisement.entity.Advertisement

import org.springframework.stereotype.Service

@Service
class AdvertisementService(private val advertisementRepository: AdvertisementRepository) {

    fun findAllAdvertisementByAdvertisementType(advertisementType: AdvertisementType): List<AdvertisementResDto>? {
        val advertisements: List<Advertisement> = advertisementRepository
            .findAllByAdvertisementType(advertisementType)
        return advertisements.map{ it.toResDto()}
    }

    fun findAll(): List<Advertisement> {
        return advertisementRepository.findAll()
    }


}