package com.ilgiz.herodotaApp.data.repositores

import androidx.lifecycle.liveData
import com.ilgiz.herodotaApp.Either
import com.ilgiz.herodotaApp.data.remote.apiservices.HeroesApiServices
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class HeroRepository @Inject constructor(private val apiService: HeroesApiServices) {

    fun fetchHeroes() = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroes()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }

    fun fetchCharacterId(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroesId(id = id)))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}