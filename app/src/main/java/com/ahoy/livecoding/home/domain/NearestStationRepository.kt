package com.ahoy.livecoding.home.domain

import com.ahoy.livecoding.home.datasource.local.LocalDataSource
import com.ahoy.livecoding.home.datasource.remove.ApiService
import com.ahoy.livecoding.home.models.ElectriStationResponse
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.network.Resource
import javax.inject.Inject

interface NearestStationsRepository {
    suspend fun getStations(isFetchFromServer:Boolean): Resource<out ElectriStationResponse>
}

class DefaultNearestNearestStationsRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: LocalDataSource
) : NearestStationsRepository {
    override suspend fun getStations(isFetchFromServer:Boolean): Resource<out ElectriStationResponse>{
        return if (isFetchFromServer){
             apiService.getAllNearestStation()
        }else localDataSource.getAllNearestStation()
    }
}