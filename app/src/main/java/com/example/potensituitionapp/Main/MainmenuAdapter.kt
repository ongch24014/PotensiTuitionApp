package com.example.potensituitionapp.Main

import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.databinding.ListItemDetailedclassBinding

class MainmenuAdapter(val clickListener: TimetableListener):ListAdapter<Timetable, MainmenuAdapter.ViewHolder>(TimetableDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: ListItemDetailedclassBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Timetable,
            clickListener: TimetableListener
        ) {
            binding.timetable=item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)

                val binding =
                    ListItemDetailedclassBinding.inflate(layoutInflater, parent, false)

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

class TimetableListener(val clickListener: (classId: String) -> Unit) {
    fun onClick(timetable: Timetable) = clickListener(timetable.classID)
}

