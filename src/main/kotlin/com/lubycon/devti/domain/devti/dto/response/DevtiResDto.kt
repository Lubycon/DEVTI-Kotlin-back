package com.lubycon.devti.domain.devti.dto.response

import com.lubycon.devti.domain.advertisement.entity.Advertisement
import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import io.swagger.annotations.ApiModelProperty

data class DevtiResDto(

    @ApiModelProperty(value = "DEVTI 16타입", example = "VPSW")
    val devti: String,

    @ApiModelProperty(value = "DEVTI 제목", example = "열정적인 꿈을 가진 당신은 야망가!")
    val devtiTitle: String,

    @ApiModelProperty(value = "DEVTI 총평", example = "당신은 블라블라해요 블라블라하면 블라블라해서 블라블라 할수있을거에요 블라블라~~")
    val generalReview: ReviewResDto,

    @ApiModelProperty(value = "Bias 결과 리스트 ")
    val biasResults: List<BiasReviewResult>,

    @ApiModelProperty(value = "학습, 채용공고")
    val advertisementList: List<Advertisement>,

    @ApiModelProperty(value = "가장 많은 유형")
    val devtiRatioList: List<DevtiRatioDto>
 )
