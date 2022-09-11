package com.ahoy.livecoding.home.datasource.remove

import com.ahoy.livecoding.home.models.ElectriStationResponse
import retrofit2.http.GET

interface Api {
    @GET("getStations")
    suspend fun getAllNearestStation(

    ): ElectriStationResponse

}