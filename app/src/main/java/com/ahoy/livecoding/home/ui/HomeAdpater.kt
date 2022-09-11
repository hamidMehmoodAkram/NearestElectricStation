package com.ahoy.livecoding.home.ui

import android.view.ViewGroup
import com.ahoy.livecoding.databinding.ListItemHomeBinding
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.util.BaseRecyclerViewAdapter
import com.ahoy.livecoding.util.BaseViewHolder
import com.ahoy.livecoding.util.inflater

class HomeAdapter(override var itemClickListener: (ElectricStation) -> Unit) :
    BaseRecyclerViewAdapter<ElectricStation, HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ListItemHomeBinding.inflate(
                parent.inflater,
                parent,
                false
            ),
            itemClickListener
        )
    }
}

class HomeViewHolder(
    private val binding: ListItemHomeBinding,
    private val itemClickListener: (ElectricStation) -> Unit
) :
    BaseViewHolder<ElectricStation>(binding.root) {
    override fun onBind(item: ElectricStation, position: Int) {
        binding.data = item
        binding.root.setOnClickListener {
            itemClickListener(item)
        }
    }
}