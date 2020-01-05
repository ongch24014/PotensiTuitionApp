package com.example.potensituitionapp.teacherdetailclass

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.R
import com.example.potensituitionapp.TextItemViewHolder
import com.example.potensituitionapp.database.Student

class TeacherdetailclassAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<Student>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.name.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.timetable_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}