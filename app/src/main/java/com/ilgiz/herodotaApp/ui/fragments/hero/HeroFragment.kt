package com.ilgiz.herodotaApp.ui.fragments.hero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson22kotlin2.R
import com.example.lesson22kotlin2.databinding.FragmentHeroBinding
import com.ilgiz.herodotaApp.Either
import com.ilgiz.herodotaApp.ui.adapters.HeroAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HeroFragment :
    Fragment(R.layout.fragment_hero) {

    private val binding by viewBinding(FragmentHeroBinding::bind)
    private val viewModel: HeroViewModel by viewModels()
    private val heroesAdapter = HeroAdapter(
        this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        setupObserves()
    }

    private fun setupRecyclerview() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    private fun setupObserves() {
        viewModel.fetchHero().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("ilgiz", it.value)
                }
                is Either.Right -> {
                    Log.e("ilgiz", it.value.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            HeroFragmentDirections.actionHeroesFragmentToHeroesDetailFragment2(
                position = id
            )
        )
    }
}


