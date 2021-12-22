package com.lubycon.devti.domain.devti.dto.response

import com.lubycon.devti.domain.bias.entity.Bias
import com.lubycon.devti.domain.review.dto.response.ReviewResDto
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class BiasReviewResult_v2(

    @ApiModelProperty(value = "Bias 정보")
    var bias: String?,

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Bias percent", example = "10")
    var weight: Int?,

    @ApiModelProperty(value = "Bias 타이틀")
    var biasTitle: String?,

    @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
    var reviewList: List<String>?
) {
    constructor() : this("", 0, "", emptyList())

}
