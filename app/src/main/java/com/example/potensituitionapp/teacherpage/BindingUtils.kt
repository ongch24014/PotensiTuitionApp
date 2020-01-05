package com.example.potensituitionapp.teacherpage

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Timetable

@BindingAdapter("roomText")
fun TextView.setRoomText(item: Timetable){
    text = item.classVenue
}

@BindingAdapter("timeText")
fun TextView.setTimeText(item: Timetable){
    text = item.classTime.toString()
}

@BindingAdapter("subjectText")
fun TextView.setSubjectText(item: Timetable){
    text = item.className
}

@BindingAdapter("dayText")
fun TextView.setDayText(item: Timetable){
    text = item.classDay
}

@BindingAdapter("constColor")
fun ConstraintLayout.setConstColor(item: Timetable){
    if (item.classDay.equals("Monday")) {
        background = ContextCompat.getDrawable(context, R.color.tt_monday)
    } else if (item.classDay.equals("Tuesday")) {
        background = ContextCompat.getDrawable(context, R.color.tt_tuesday)

    } else if (item.classDay.equals("Wednesday")) {
        background = ContextCompat.getDrawable(context, R.color.tt_wednesday)

    } else if (item.classDay.equals("Thursday")) {
        background = ContextCompat.getDrawable(context, R.color.tt_thursday)

    } else if (item.classDay.equals("Friday")) {
        background = ContextCompat.getDrawable(context, R.color.tt_friday)
    }
}




//binding.room.text = item.classVenue
//binding.time.text = item.classTime.toString()
//binding.subject.text = item.className.toString()
//binding.day.text = item.classDay.toString()