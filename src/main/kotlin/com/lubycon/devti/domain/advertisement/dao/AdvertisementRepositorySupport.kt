package com.lubycon.devti.domain.advertisement.dao

import com.lubycon.devti.global.code.AdvertisementType
import com.lubycon.devti.domain.advertisement.entity.Advertisement
import org.springframework.transaction.annotation.Transactional

interface AdvertisementRepositorySupport {

    @Transactional(readOnly = true)
    fun findAllByAdvertisementType(advertisementType: AdvertisementType): List<Advertisement>
}