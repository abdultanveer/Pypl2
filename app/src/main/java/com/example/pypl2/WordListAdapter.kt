package com.example.pypl2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.pypl2.network.MarsPhoto

class WordListAdapter : ListAdapter<MarsPhoto, WordListAdapter.WordViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.imgSrc)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.tvVistingcard)
        private val imageView:ImageView = itemView.findViewById(R.id.iv_card)

        fun bind(text: String?) {
            wordItemView.text = text
            imageView.load(text)
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.visiting_card, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrc == newItem.imgSrc
        }
    }
}