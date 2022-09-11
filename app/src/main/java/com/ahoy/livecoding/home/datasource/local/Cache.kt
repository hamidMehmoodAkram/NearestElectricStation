package com.ahoy.livecoding.home.datasource.local

import com.ahoy.livecoding.home.models.ElectriStationResponse
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.network.Resource

fun getListNearestStations():Resource<out ElectriStationResponse>{
    return Resource.Data(ElectriStationResponse(getList()))
}

fun getList():List<ElectricStation>{
    val mutableList = mutableListOf<ElectricStation>()
    for (item in 0 ..15){
        mutableList.add(ElectricStation("Station $item"))
    }
    return mutableList
}