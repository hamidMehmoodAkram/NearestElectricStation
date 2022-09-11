package com.ahoy.livecoding.home.datasource.local

import com.ahoy.livecoding.home.models.ElectriStationResponse
import com.ahoy.livecoding.network.BaseService
import com.ahoy.livecoding.network.Resource
import com.ahoy.livecoding.resources.StringResourceProvider
import javax.inject.Inject

interface LocalDataSource {
    suspend fun getAllNearestStation(): Resource<out ElectriStationResponse>
}

class DefaultLocalDataSource @Inject constructor(
    private val localDb: Database,
    stringRes: StringResourceProvider,
) : LocalDataSource, BaseService(stringRes) {

    override suspend fun getAllNearestStation(): Resource<out ElectriStationResponse> {
        return localDb.getAllNearestStation()
    }
}