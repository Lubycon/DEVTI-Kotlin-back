package com.lubycon.devti.domain.new_advertisement.dto


data class CreateLectureRequest(
    var name: String,
    var slogan: String,
    var platform: String,
    var url: String,
    var targetBias: String,
    var careers: List<Int>
)
