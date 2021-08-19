package com.lubycon.devti.domain.advertisement.api

import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto
import com.lubycon.devti.global.code.AdvertisementType
import com.lubycon.devti.domain.advertisement.service.AdvertisementService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/advertisement")
@Api(value = "Advertisement")
class AdvertisementController(private val advertisementService: AdvertisementService) {

    @GetMapping
    @ApiOperation(value = "광고 리스트 불러오기")
    @ApiImplicitParams(
        ApiImplicitParam(name = "advertisementType",
            value = "ALL: 전체조회\n" +
                    "LECTURE: 강의광고\n" +
                    "RECRUIT: 채용공고",
            dataType = "AdvertisementType",
            paramType = "query")
    )
    fun getAdvertisementAdvertisementType(
        @RequestParam(defaultValue = "ALL") advertisementType: AdvertisementType
    )
    : ResponseEntity<List<AdvertisementResDto>> {
        return ResponseEntity.ok(advertisementService.findAllAdvertisementByAdvertisementType(advertisementType))
    }


}