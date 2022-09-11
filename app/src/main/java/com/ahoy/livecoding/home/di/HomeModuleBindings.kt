package com.ahoy.livecoding.home.di

import com.ahoy.livecoding.home.datasource.local.DefaultLocalDataSource
import com.ahoy.livecoding.home.datasource.local.LocalDataSource
import com.ahoy.livecoding.home.datasource.remove.DefaultApiService
import com.ahoy.livecoding.home.datasource.remove.ApiService
import com.ahoy.livecoding.home.domain.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModuleBindings {

    @Binds
    abstract fun bindService(instance: DefaultApiService): ApiService

    @Binds
    abstract fun bindUseCase(instance: DefaultGetNearestNearestStationsUseCase): GetNearestStationsUseCase

    @Binds
    abstract fun bindElectricStationRepository(instance: DefaultNearestNearestStationsRepository): NearestStationsRepository

    @Binds
    abstract fun bindLocalDataSource(instance: DefaultLocalDataSource): LocalDataSource
}