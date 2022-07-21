package com.ilgiz.herodotaApp.data.remote.apiservices

import com.ilgiz.herodotaApp.models.DetailHeroModel
import com.ilgiz.herodotaApp.models.DocsHeroesModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroesApiServices {

    @GET("heroes")
    suspend fun fetchHeroes(): List<DocsHeroesModel>

    @GET("heroes/{hero_id}/matches")
    suspend fun fetchHeroesId(
        @Path("hero_id") id: Int
    ): List<DetailHeroModel>
}