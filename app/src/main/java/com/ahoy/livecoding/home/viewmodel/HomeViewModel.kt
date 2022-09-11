package com.ahoy.livecoding.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahoy.livecoding.app.common.BaseViewModel
import com.ahoy.livecoding.home.domain.GetNearestStationsUseCase
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.home.models.RequestStation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val stationsUseCase: GetNearestStationsUseCase) : BaseViewModel<Any>() {

    val homeLiveData: LiveData<List<ElectricStation>>
        get() = _homeLiveData
    private val _homeLiveData: MutableLiveData<List<ElectricStation>> by lazy {
        MutableLiveData()
    }

    init {
        getAllStations()
    }

    fun getAllStations(){
        unZipViewStateFlow(stationsUseCase(getParams()), onSuccess = {
            _homeLiveData.value = it as List<ElectricStation>
        })
    }

    fun getParams() = RequestStation(0.0,0.0)
}