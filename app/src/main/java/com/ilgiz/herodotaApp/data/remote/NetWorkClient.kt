package com.ilgiz.herodotaApp.data.remote

import com.ilgiz.herodotaApp.data.remote.apiservices.HeroesApiServices
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideHeroesApiService() = provideRetrofit.create(HeroesApiServices::class.java)
}