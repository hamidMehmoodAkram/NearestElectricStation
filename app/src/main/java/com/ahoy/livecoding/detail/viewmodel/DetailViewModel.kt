package com.ahoy.livecoding.detail.viewmodel

import com.ahoy.livecoding.app.common.BaseViewModel
import com.ahoy.livecoding.home.domain.GetNearestStationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val stationsUseCase: GetNearestStationsUseCase) : BaseViewModel<Any>() {

}