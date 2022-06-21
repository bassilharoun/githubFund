package com.apps.coursekotlin0.CarsApp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.coursekotlin0.databinding.ItemCarsBinding

class BullsCarsViewPagerAdapter (var images : List<Int>) : RecyclerView.Adapter<BullsCarsViewPagerAdapter.BullsCarsViewHolder>() {

    inner class BullsCarsViewHolder(val binding: ItemCarsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BullsCarsViewHolder {
        return BullsCarsViewHolder(ItemCarsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BullsCarsViewHolder, position: Int) {
        val currentCarImage = images[position]
        holder.binding.ivCars1.setImageResource(currentCarImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}