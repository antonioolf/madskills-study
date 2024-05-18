package com.oliveiralabs.estudosmadskills.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oliveiralabs.estudosmadskills.databinding.ItemKitBinding
import com.oliveiralabs.estudosmadskills.model.Kit
import com.squareup.picasso.Picasso

class KitAdapter(private val kits: List<Kit>) : RecyclerView.Adapter<KitAdapter.KitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitViewHolder {
        val binding = ItemKitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KitViewHolder, position: Int) {
        holder.bind(kits[position])
    }

    override fun getItemCount(): Int = kits.size

    class KitViewHolder(private val binding: ItemKitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kit: Kit) {
            binding.kitName.text = kit.name
            Picasso.get().load(kit.coverUrl).into(binding.kitCover)
        }
    }
}
