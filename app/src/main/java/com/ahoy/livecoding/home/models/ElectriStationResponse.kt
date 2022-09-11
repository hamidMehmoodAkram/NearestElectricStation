package com.ahoy.livecoding.home.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class  ElectriStationResponse(
    val data: List<ElectricStation>
)