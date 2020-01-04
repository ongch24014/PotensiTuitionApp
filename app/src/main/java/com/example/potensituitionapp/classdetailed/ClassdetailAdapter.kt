package com.example.potensituitionapp.classdetailed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.database.Chapter
import com.example.potensituitionapp.databinding.ListItemChapterBinding
import com.example.potensituitionapp.databinding.ListItemDetailedclassBinding

class ClassdetailAdapter(val clickListener: ChapterListener):
    ListAdapter<Chapter, ClassdetailAdapter.ViewHolder>(ChapterDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: ListItemChapterBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Chapter,clickListener: ChapterListener) {
            binding.chapter = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemChapterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class ChapterDiffCallback : DiffUtil.ItemCallback<Chapter>() {
    override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem.chapterNum == newItem.chapterNum
    }

    override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem == newItem
    }
}

class ChapterListener(val clickListener: (classnum: Int) -> Unit) {
    fun onClick(chapter: Chapter) = clickListener(chapter.chapterNum)
}