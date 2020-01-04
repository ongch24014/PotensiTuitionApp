package com.example.potensituitionapp.classdetailed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.R
import com.example.potensituitionapp.TextItemViewHolder
import com.example.potensituitionapp.database.Chapter
import com.example.potensituitionapp.databinding.ListItemChapterBinding

class ClassdetailAdapter: RecyclerView.Adapter<ClassdetailAdapter.ViewHolder>() {
    var data =  listOf<Chapter>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.chapterName.text = item.chapterNum.toString()
        holder.chapterDesc.text = item.chapterDesc
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_chapter, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chapterName: TextView = itemView.findViewById(R.id.chapter_name)
        val chapterDesc: TextView = itemView.findViewById(R.id.chapter_desc)
    }

}