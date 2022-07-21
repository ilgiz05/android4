package com.ilgiz.herodotaApp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22kotlin2.databinding.ItemHeroesBinding
import com.ilgiz.herodotaApp.models.DocsHeroesModel
import kotlin.reflect.KFunction1

class HeroAdapter(private val itemClick: KFunction1<Int, Unit>
) : androidx.recyclerview.widget.ListAdapter<DocsHeroesModel, HeroAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHeroesBinding.inflate(
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
        private val binding: ItemHeroesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DocsHeroesModel) {
            binding.itemHeroesName.text = item.name

            binding.root.setOnClickListener {
                itemClick(item.id)
            }
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<DocsHeroesModel> =
            object : DiffUtil.ItemCallback<DocsHeroesModel>() {
                override fun areItemsTheSame(
                    oldItem: DocsHeroesModel,
                    newItem: DocsHeroesModel
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: DocsHeroesModel,
                    newItem: DocsHeroesModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
