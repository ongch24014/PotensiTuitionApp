package com.example.potensituitionapp.Main

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.R
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

@BindingAdapter("layoutCons")
fun ConstraintLayout.setTeacherNameString(item: Timetable?) {
    item?.let {
        //background = ContextCompat.getDrawable(context, R.color.tt_friday)
    }
}