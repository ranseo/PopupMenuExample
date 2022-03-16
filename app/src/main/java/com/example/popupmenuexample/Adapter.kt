package com.example.popupmenuexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popupmenuexample.databinding.ListItemBinding

class Adapter : ListAdapter<DataClass, Adapter.ViewHolder>(DataClass.dataClassCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
    }

    class ViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}