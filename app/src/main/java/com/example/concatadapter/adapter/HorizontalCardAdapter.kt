package com.example.concatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.GamesData
import com.example.concatadapter.databinding.CardAdapterBinding

class HorizontalCardAdapter (
    private var games: MutableList<GamesData>
) : RecyclerView.Adapter<HorizontalCardAdapter.Holder>() {
    class Holder(private val binding: CardAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: GamesData) {
            binding.gameImage.setImageResource(game.image)
            binding.gameName.text = game.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = CardAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(games[position])
    }
}