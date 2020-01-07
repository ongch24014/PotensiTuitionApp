package com.example.potensituitionapp.Enrollment

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.database.Course

@BindingAdapter("courseNameString")
fun TextView.setCourseName(item: Course) {
    item?.let {
        text = item.courseName
    }
}

@BindingAdapter("courseNameDesc")
fun TextView.setCourseDesc(item: Course) {
    item?.let {
        text = item.courseDescripton
    }
}

@BindingAdapter("constLayout")
fun ConstraintLayout.setCons(item: Course) {
    item?.let {

    }
}