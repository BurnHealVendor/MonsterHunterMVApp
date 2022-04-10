package com.example.monsterhuntermvapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.monsterhuntermvapp.databinding.MotionValueItemBinding
import com.example.monsterhuntermvapp.model.MotionValues
import com.example.monsterhuntermvapp.model.MotionValuesItem

class MotionValuesAdapter(
    private val motionValues: MutableList<MotionValues> = mutableListOf()
) : RecyclerView.Adapter<MotionValuesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotionValuesViewHolder {
        return MotionValuesViewHolder(
            MotionValueItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MotionValuesViewHolder, position: Int) =
        holder.bind(motionValues[position])

    override fun getItemCount(): Int = motionValues.size
}

class MotionValuesViewHolder(
    private val binding: MotionValueItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(motionValues: MotionValues) {

    }
}