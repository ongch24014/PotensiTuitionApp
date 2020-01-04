package com.example.potensituitionapp.Main

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.database.Timetable

@BindingAdapter("classNameString")
fun TextView.setClassNameString(item: Timetable?) {
    item?.let {
        text = item.className
    }
}

@BindingAdapter("teacherNameString")
fun TextView.setTeacherNameString(item: Timetable?) {
    item?.let {
        text = item.teacherID
    }
}