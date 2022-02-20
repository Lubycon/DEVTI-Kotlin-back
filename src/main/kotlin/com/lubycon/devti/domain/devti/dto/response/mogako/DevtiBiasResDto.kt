package com.lubycon.devti.domain.devti.dto.response.mogako

import com.lubycon.devti.domain.review.dto.response.ResultResDto
import io.swagger.annotations.ApiModelProperty

data class DevtiBiasResDto(

    var id: Int,
    var bias1: biasResNewDto,
    var bias2: biasResNewDto,
    var pillarTitle: String,
    @ApiModelProperty(value = "Bias 타이틀")
    val biasTitle: String,
    @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
    val reviewList: List<ResultResDto>?


)
