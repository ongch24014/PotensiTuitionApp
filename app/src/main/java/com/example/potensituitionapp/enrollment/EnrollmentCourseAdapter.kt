package com.example.potensituitionapp.enrollment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.database.Course
import com.example.potensituitionapp.databinding.ListItemCoursesBinding

class EnrollmentCourseAdapter(val clickListener: CourseListener):
    ListAdapter<Course,EnrollmentCourseAdapter.ViewHolder>(CourseDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemCoursesBinding) : RecyclerView.ViewHolder(binding.root){

         fun bind(
             item: Course,
             clickListener: CourseListener
         ) {
            binding.course = item
             binding.clickListener = clickListener
             binding.executePendingBindings()
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemCoursesBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }

    }
}

class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.courseID == newItem.courseID

    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }

}

class CourseListener(val clickListener: (courseId: String) -> Unit){
    fun onClick(course:Course) = clickListener(course.courseID)
}