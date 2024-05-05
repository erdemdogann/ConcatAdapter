package com.example.concatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.GamesData
import com.example.concatadapter.databinding.AdapterBinding

class HorizontalAdapter(
    private val games: MutableList<GamesData>
) : RecyclerView.Adapter<HorizontalAdapter.Holder>() {

    inner class Holder(private val binding: AdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: GamesData) {
            binding.recycler.apply {
                layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

                adapter = HorizontalCardAdapter(games = games)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = AdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(games[position])
    }
}