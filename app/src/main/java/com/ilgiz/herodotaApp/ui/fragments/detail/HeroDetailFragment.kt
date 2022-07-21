package com.ilgiz.herodotaApp.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson22kotlin2.R
import com.example.lesson22kotlin2.databinding.FragmentHeroDetailBinding
import com.ilgiz.herodotaApp.Either
import com.ilgiz.herodotaApp.ui.adapters.DetailHeroAdapter


class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail){

    private val viewBinding by viewBinding(FragmentHeroDetailBinding::bind)
    private val viewModel: HeroDetailViewModel by viewModels()
    private val args by navArgs<HeroDetailFragmentArgs>()
    private val detailHeroesAdapter = DetailHeroAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        getData()
    }

    private fun initRecyclerview() = with(viewBinding.detailHeroesRecview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = detailHeroesAdapter
    }

    private fun getData() {
        viewModel.fetchHeroId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("ilgiz", it.value.toString())
                }
                is Either.Right -> {
                    detailHeroesAdapter.submitList(it.value)
                }
            }
        }
    }
}