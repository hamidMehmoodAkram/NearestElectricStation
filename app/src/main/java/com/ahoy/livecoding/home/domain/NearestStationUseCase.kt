package com.ahoy.livecoding.home.domain

import com.ahoy.livecoding.app.common.FlowUseCase
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.home.models.RequestStation
import com.ahoy.livecoding.home.models.UIState
import com.ahoy.livecoding.network.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetNearestStationsUseCase :
    FlowUseCase<RequestStation, UIState<List<ElectricStation>>> {
    override fun dispatcher(): CoroutineDispatcher = Dispatchers.IO
}

class DefaultGetNearestNearestStationsUseCase @Inject constructor(private val nearestStationsRepository: NearestStationsRepository) : GetNearestStationsUseCase {
    override fun execute(parameters: RequestStation) =
        flow {
            emit(UIState.Loading)
            kotlinx.coroutines.delay(2000)
            when (val response = nearestStationsRepository.getStations(false)) {
                is Resource.Error -> emit(UIState.Error(response.errorMessage))
                is Resource.Data -> emit(UIState.Success(response.data.data))
            }
    }
}