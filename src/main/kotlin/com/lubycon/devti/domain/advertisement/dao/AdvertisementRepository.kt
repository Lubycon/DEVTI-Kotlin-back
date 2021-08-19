package com.lubycon.devti.domain.advertisement.dao

import com.lubycon.devti.domain.advertisement.entity.Advertisement
import org.springframework.data.jpa.repository.JpaRepository

interface AdvertisementRepository : JpaRepository<Advertisement, Long>, AdvertisementRepositorySupport {
}