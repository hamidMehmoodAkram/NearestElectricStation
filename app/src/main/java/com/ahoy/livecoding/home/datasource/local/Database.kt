package com.ahoy.livecoding.home.datasource.local

import com.ahoy.livecoding.home.models.ElectriStationResponse
import com.ahoy.livecoding.network.Resource

interface Database {
    suspend fun getAllNearestStation(): Resource<out ElectriStationResponse>
}

class DefaultDatabase(): Database {
    override suspend fun getAllNearestStation(): Resource<out ElectriStationResponse> {
        return getListNearestStations()
    }
}