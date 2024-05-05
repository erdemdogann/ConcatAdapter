package com.example.concatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.TitleCardBinding

class TitleCardAdapter(
    private val title: String
) : RecyclerView.Adapter<TitleCardAdapter.Holder>() {

    inner class Holder(private val binding: TitleCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.title.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TitleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }
}