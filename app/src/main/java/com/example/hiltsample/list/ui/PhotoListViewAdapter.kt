package com.example.hiltsample.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltsample.databinding.ListItemPhotoBinding

class PhotoListViewAdapter : ListAdapter<UiData, ListViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<UiData>() {
        override fun areItemsTheSame(oldItem: UiData, newItem: UiData): Boolean {
            return oldItem::class.java == newItem::class.java
        }

        override fun areContentsTheSame(oldItem: UiData, newItem: UiData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        holder.onBind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }
}

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {

}