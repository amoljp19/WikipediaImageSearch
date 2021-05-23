package com.softaai.wikipediaimagesearch.imagesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.softaai.wikipediaimagesearch.R
import com.softaai.wikipediaimagesearch.model.Pages

class WikiSearchListAdapter : ListAdapter<Pages, WikiSearchListAdapter.WikiSearchViewHolder>(WikiSearchComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WikiSearchViewHolder {
        return WikiSearchViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WikiSearchViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.x7199609?.thumbnail?.source)
    }

    class WikiSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(imageUrl: String?) {
            image.load(imageUrl) {
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_foreground)
            }
        }

        companion object {
            fun create(parent: ViewGroup): WikiSearchViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WikiSearchViewHolder(view)
            }
        }
    }

    class WikiSearchComparator : DiffUtil.ItemCallback<Pages>() {
        override fun areItemsTheSame(oldItem: Pages, newItem: Pages): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Pages, newItem: Pages): Boolean {
            return oldItem.x11903589 == newItem.x11903589
        }
    }

}