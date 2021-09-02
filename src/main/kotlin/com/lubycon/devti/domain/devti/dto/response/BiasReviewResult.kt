package com.lubycon.devti.domain.devti.dto.response

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class BiasReviewResult(

    @ApiModelProperty(value = "Bias 정보")
    val bias: Bias,

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Bias percent", example = "10")
    val weight: Int?,

    @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
    val review: ReviewResDto

)
