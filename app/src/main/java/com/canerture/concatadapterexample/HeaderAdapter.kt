package com.canerture.concatadapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.concatadapterexample.databinding.ItemHeaderBinding

//Her başlık için bu adapterı kullanacağız. Bu sebeple argüman olarak headerText istiyoruz.
class HeaderAdapter(private val headerText: String) : RecyclerView.Adapter<HeaderAdapter.HeaderDesign>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val headerBinding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
        return HeaderDesign(headerBinding)
    }

    override fun onBindViewHolder(holder: HeaderDesign, position: Int) {
        holder.bind(headerText)
    }

    class HeaderDesign(private var headerBinding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(headerBinding.root) {

        fun bind(headerText: String) {
            headerBinding.tvHeader.text = headerText
        }

    }

    override fun getItemCount(): Int = 1

}