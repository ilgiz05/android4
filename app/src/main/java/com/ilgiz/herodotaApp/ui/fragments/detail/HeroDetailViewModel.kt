package com.ilgiz.herodotaApp.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.ilgiz.herodotaApp.data.repositores.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(private val repository: HeroRepository) :
    ViewModel() {

    fun fetchHeroId(position: Int) = repository.fetchCharacterId(position)
}