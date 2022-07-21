package com.ilgiz.herodotaApp.di

import com.ilgiz.herodotaApp.data.remote.NetWorkClient
import com.ilgiz.herodotaApp.data.remote.apiservices.HeroesApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideHeroesApiService(netWorkClient: NetWorkClient): HeroesApiServices =
        netWorkClient.provideHeroesApiService()
}