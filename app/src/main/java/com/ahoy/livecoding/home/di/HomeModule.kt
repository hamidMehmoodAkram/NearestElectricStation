package com.ahoy.livecoding.home.di

import com.ahoy.livecoding.home.datasource.local.Database
import com.ahoy.livecoding.home.datasource.local.DefaultDatabase
import com.ahoy.livecoding.home.datasource.remove.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {
    @Provides
    fun providePoiApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Provides
    fun provideDB():Database = DefaultDatabase()

}