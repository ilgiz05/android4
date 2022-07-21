package com.ilgiz.herodotaApp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22kotlin2.databinding.ItemDetailHeroesBinding
import com.ilgiz.herodotaApp.models.DetailHeroModel


class DetailHeroAdapter() :
    androidx.recyclerview.widget.ListAdapter<DetailHeroModel, DetailHeroAdapter.ViewHolder>(
        diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDetailHeroesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemDetailHeroesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DetailHeroModel) {
            binding.nameDetailHeroes.text = item.leagueName

        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<DetailHeroModel> =
            object : DiffUtil.ItemCallback<DetailHeroModel>() {
                override fun areItemsTheSame(
                    oldItem: DetailHeroModel,
                    newItem: DetailHeroModel
                ): Boolean {
                    return oldItem.matchId == newItem.matchId
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: DetailHeroModel,
                    newItem: DetailHeroModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}