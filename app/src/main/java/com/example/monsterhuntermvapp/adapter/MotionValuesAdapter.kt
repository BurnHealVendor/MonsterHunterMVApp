package com.example.monsterhuntermvapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.monsterhuntermvapp.databinding.MotionValueItemBinding
import com.example.monsterhuntermvapp.model.MotionValuesItem

class MotionValuesAdapter(
    private val motionValuesItem: MutableList<MotionValuesItem> = mutableListOf()
) : RecyclerView.Adapter<MotionValuesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotionValuesViewHolder {
        return MotionValuesViewHolder(
            MotionValueItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MotionValuesViewHolder, position: Int) =
        holder.bind(motionValuesItem[position])

    override fun getItemCount(): Int = motionValuesItem.size

    fun setMVData(newMVs: List<MotionValuesItem>) {
        motionValuesItem.clear()
        motionValuesItem.addAll(newMVs)
        notifyDataSetChanged()
    }

    fun getMVData(position: Int): MotionValuesItem {
        val damageType: String = motionValuesItem[position].damageType
        val exhaust: Int = motionValuesItem[position].exhaust
        val hits: List<Int> = motionValuesItem[position].hits
        val id: Int = motionValuesItem[position].id
        val name: String = motionValuesItem[position].name
        val stun: Int = motionValuesItem[position].stun
        val weaponType: String = motionValuesItem[position].weaponType

        return MotionValuesItem(damageType, exhaust, hits, id, name, stun, weaponType)
    }
}

class MotionValuesViewHolder(
    private val binding: MotionValueItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(motionValuesItem: MotionValuesItem) {
        binding.mvName.text = motionValuesItem.name
        binding.mvDamageType.text = motionValuesItem.damageType
        binding.mvStun.text = motionValuesItem.stun.toString()
        binding.mvExhaust.text = motionValuesItem.exhaust.toString()
        binding.mvHits.text = motionValuesItem.hits.toString()
    }
}