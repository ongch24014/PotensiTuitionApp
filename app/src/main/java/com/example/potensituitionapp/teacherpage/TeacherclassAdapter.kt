package com.example.potensituitionapp.teacherpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.databinding.ListItemTimetableBinding

class TeacherclassAdapter(val clickListener: TimetableListener): ListAdapter<Timetable,TeacherclassAdapter.ViewHolder>(TimetableDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(getItem(position)!!, clickListener)
        holder.bind(item, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)

    }

    class ViewHolder private constructor(val binding: ListItemTimetableBinding) : RecyclerView.ViewHolder(binding.root){

         fun bind(
             item: Timetable,
             clickListener: TimetableListener
         ) {
             binding.clickListener = clickListener
             binding.timetable = item
             binding.executePendingBindings()
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = ListItemTimetableBinding.inflate(layoutInflater,parent,false)

                return ViewHolder(binding)
            }
        }

    }

}

class TimetableDiffCallback : DiffUtil.ItemCallback<Timetable>() {
    override fun areItemsTheSame(oldItem: Timetable, newItem: Timetable): Boolean {
        return oldItem.classID == newItem.classID
    }

    override fun areContentsTheSame(oldItem: Timetable, newItem: Timetable): Boolean {
        return oldItem == newItem
    }
}

class TimetableListener(val clickListener: (classId: String) -> Unit){
    fun onClick(timetable: Timetable) = clickListener(timetable.classID)
}