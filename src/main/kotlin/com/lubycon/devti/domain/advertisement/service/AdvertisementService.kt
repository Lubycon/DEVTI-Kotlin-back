package com.lubycon.devti.domain.advertisement.service

import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto
import com.lubycon.devti.domain.advertisement.entity.Advertisement
import com.lubycon.devti.global.code.AdvertisementType
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class AdvertisementService(private val advertisementRepository: AdvertisementRepository) {

    fun findAllAdvertisementByAdvertisementType(advertisementType: AdvertisementType): List<AdvertisementResDto> {
        val advertisementList: List<Advertisement> = advertisementRepository
            .findAllByAdvertisementType(advertisementType)

        return advertisementList
            .stream()
            .map(Advertisement::toResDto)
            .collect(Collectors.toList())

    }

    fun findAll(): List<Advertisement> {
        return advertisementRepository.findAll()
    }


}