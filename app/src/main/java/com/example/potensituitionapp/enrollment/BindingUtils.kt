package com.example.potensituitionapp.Enrollment

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.R
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
        if(item.courseName.equals("Biology")) {
            background = ContextCompat.getDrawable(context, R.color.tt_monday)
        }

        else if(item.courseName.equals("Chemistry")){
            background = ContextCompat.getDrawable(context, R.color.tt_thursday)
        }

        else if(item.courseName.equals("Physics")){
            background = ContextCompat.getDrawable(context, R.color.tt_wednesday)
        }

        else if(item.courseName.equals("English")){
            background = ContextCompat.getDrawable(context, R.color.design_default_color_primary)
        }

        else if(item.courseName.equals("Chinese")){
            background = ContextCompat.getDrawable(context, R.color.tt_tuesday)
        }
    }
}