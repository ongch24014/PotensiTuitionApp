package com.example.potensituitionapp.timetable

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.potensituitionapp.R
import com.example.potensituitionapp.TextItemViewHolder
import com.example.potensituitionapp.database.Timetable
import org.w3c.dom.Text

class TimetableAdapter: RecyclerView.Adapter<TimetableAdapter.ViewHolder>() {

    var data = listOf<Timetable>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources

        holder.roomc.text = item.classVenue
        holder.time.text = item.classTime.toString()
        holder.subject.text = item.className.toString()
        holder.day.text = item.classDay.toString()

        if(holder.day.text.equals("Monday")){
            holder.back.setBackgroundResource(R.color.colorPrimary)
        }

        else if(holder.day.text.equals("Tuesday")){
            holder.back.setBackgroundResource(R.color.colorAccent)

        }

        else if(holder.day.text.equals("Wednesday")){
            holder.back.setBackgroundResource(R.color.colorTimetable)

        }

        else if(holder.day.text.equals("Thursday")){
            holder.back.setBackgroundResource(R.color.colorPrimaryDark)

        }

        else if(holder.day.text.equals("Friday")){
            holder.back.setBackgroundColor(Color.YELLOW)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_timetable,
                parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val subject: TextView = itemView.findViewById(R.id.subject)
        val roomc: TextView = itemView.findViewById(R.id.room)
        val time: TextView = itemView.findViewById(R.id.time)
        val day:TextView = itemView.findViewById(R.id.day)
        val back:ConstraintLayout = itemView.findViewById(R.id.constraint_layout)


    }
}