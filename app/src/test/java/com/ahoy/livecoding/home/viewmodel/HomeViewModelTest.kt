package com.ahoy.livecoding.home.viewmodel

import com.ahoy.livecoding.BaseTest
import com.ahoy.livecoding.getOrAwaitValue
import com.ahoy.livecoding.home.datasource.local.getList
import com.ahoy.livecoding.home.domain.GetNearestStationsUseCase
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.home.models.RequestStation
import com.ahoy.livecoding.home.models.UIState
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.flow
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest: BaseTest() {

    @Mock
    lateinit var getNearestStationsUseCase: GetNearestStationsUseCase

    lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(getNearestStationsUseCase)
    }

    @Test
    fun `fetch nearest electric station live data triggers on successfully fetched list`() {

        val flow = flow<UIState<List<ElectricStation>>> {
            emit(UIState.Success(getList()))
        }

        whenever(getNearestStationsUseCase(any())).thenReturn(flow)
        homeViewModel.getAllStations()
        val result = homeViewModel.homeLiveData.getOrAwaitValue()
        val viewState = homeViewModel.viewStateLiveData.getOrAwaitValue()

        Assert.assertTrue(viewState is UIState.Success)
        Assert.assertTrue(result.isNotEmpty())
    }

    @Test
    fun `Given Failure response, when fetchStations is called UI state should be produced`() {
        val errorMessage = ""
        whenever(getNearestStationsUseCase(any())).thenReturn(
            flow {
                emit(UIState.Error(errorMessage))
            }
        )

        homeViewModel.getAllStations()

        val viewState = homeViewModel.viewStateLiveData.getOrAwaitValue()

        Assert.assertNotNull(viewState is UIState.Error)
    }
}