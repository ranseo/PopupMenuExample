package com.example.popupmenuexample

import androidx.recyclerview.widget.DiffUtil

data class DataClass(
    val id: Long,
    val content : String
)  {
    companion object {
        val dataClassCallback = object : DiffUtil.ItemCallback<DataClass>(){
            override fun areItemsTheSame(oldItem: DataClass, newItem: DataClass): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DataClass, newItem: DataClass): Boolean = oldItem == newItem

        }

    }
}