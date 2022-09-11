package com.ahoy.livecoding.home.datasource.remove

import com.ahoy.livecoding.home.models.ElectriStationResponse
import com.ahoy.livecoding.network.BaseService
import com.ahoy.livecoding.network.Resource
import com.ahoy.livecoding.resources.StringResourceProvider
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface ApiService {
    suspend fun getAllNearestStation(): Resource<out ElectriStationResponse>
}

class DefaultApiService @Inject constructor(
    private val api: Api,
    stringRes: StringResourceProvider,
) : ApiService, BaseService(stringRes) {

    override suspend fun getAllNearestStation(): Resource<out ElectriStationResponse> {
        return requestApiResource { api.getAllNearestStation() }
    }
}
