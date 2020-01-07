package com.example.potensituitionapp.Main

import android.widget.LinearLayout
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

        if(item.className.equals("Biology")) {
            setTextColor(ContextCompat.getColor(context, R.color.tt_monday))
        }

        else if(item.className.equals("Chemistry")){
            setTextColor(ContextCompat.getColor(context, R.color.tt_thursday))
        }

        else if(item.className.equals("Physics")){
            setTextColor(ContextCompat.getColor(context, R.color.tt_wednesday))
        }

        else if(item.className.equals("English")){
            setTextColor(ContextCompat.getColor(context, R.color.design_default_color_primary))
        }

        else if(item.className.equals("Chinese")){
            setTextColor(ContextCompat.getColor(context, R.color.tt_tuesday))
        }
    }
}

@BindingAdapter("teacherNameString")
fun TextView.setTeacherNameString(item: Timetable?) {
    item?.let {
        //text = item.teacherID
    }
}

@BindingAdapter("layoutCons")
fun ConstraintLayout.setTeacherNameString(item: Timetable?) {
    item?.let {
        item?.let {
            if(item.className.equals("Biology")) {
                background = ContextCompat.getDrawable(context, R.color.tt_monday)
            }

            else if(item.className.equals("Chemistry")){
                background = ContextCompat.getDrawable(context, R.color.tt_thursday)
            }

            else if(item.className.equals("Physics")){
                background = ContextCompat.getDrawable(context, R.color.tt_wednesday)
            }

            else if(item.className.equals("English")){
                background = ContextCompat.getDrawable(context, R.color.design_default_color_primary)
            }

            else if(item.className.equals("Chinese")){
                background = ContextCompat.getDrawable(context, R.color.tt_tuesday)
            }
        }
    }
}

@BindingAdapter("linearl")
fun LinearLayout.setLinearl(item: Timetable?) {
    item?.let {
        if(item.className.equals("Biology")) {
            background = ContextCompat.getDrawable(context, R.color.tt_monday)
        }

        else if(item.className.equals("Chemistry")){
            background = ContextCompat.getDrawable(context, R.color.tt_thursday)
        }

        else if(item.className.equals("Physics")){
            background = ContextCompat.getDrawable(context, R.color.tt_wednesday)
        }

        else if(item.className.equals("English")){
            background = ContextCompat.getDrawable(context, R.color.design_default_color_primary)
        }

        else if(item.className.equals("Chinese")){
            background = ContextCompat.getDrawable(context, R.color.tt_tuesday)
        }
    }
}