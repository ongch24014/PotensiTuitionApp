package com.example.potensituitionapp.Enrollment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.R
import com.example.potensituitionapp.TextItemViewHolder
import com.example.potensituitionapp.database.Course

class EnrollmentCourseAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_enrollment, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.courseName
    }
    var data =listOf<Course>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

}