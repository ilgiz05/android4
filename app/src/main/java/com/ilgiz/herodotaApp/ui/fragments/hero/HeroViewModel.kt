package com.ilgiz.herodotaApp.ui.fragments.hero

import androidx.lifecycle.ViewModel
import com.ilgiz.herodotaApp.data.repositores.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HeroViewModel @Inject constructor(private val repository: HeroRepository) :
    ViewModel() {

    fun fetchHero() = repository.fetchHeroes()
}