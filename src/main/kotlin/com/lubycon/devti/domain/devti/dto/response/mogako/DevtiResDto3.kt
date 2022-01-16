package com.lubycon.devti.domain.devti.dto.response.mogako

import com.lubycon.devti.domain.advertisement.entity.Advertisement
import com.lubycon.devti.domain.devti.dto.response.BiasReviewResult
import com.lubycon.devti.domain.devti.dto.response.DevtiRatioDto
import com.lubycon.devti.domain.review.dto.response.GeneralReviewDto
import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import io.swagger.annotations.ApiModelProperty

data class DevtiResDto3(

    @ApiModelProperty(value = "DEVTI 총평", example = "당신은 블라블라해요 블라블라하면 블라블라해서 블라블라 할수있을거에요 블라블라~~")
    val generalReview: GeneralReviewDto,

    @ApiModelProperty(value = "Bias 결과 리스트 ")
    val biasResults: List<DEVTIResNewDto>,

    @ApiModelProperty(value = "학습, 채용공고")
    val advertisementList: List<Advertisement>,

    @ApiModelProperty(value = "가장 많은 유형")
    val devtiRatioList: List<DevtiRatioDto>
 )
