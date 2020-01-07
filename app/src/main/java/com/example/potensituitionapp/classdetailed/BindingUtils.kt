package com.example.potensituitionapp.classdetailed

import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Chapter

@BindingAdapter("chapterNameString")
fun TextView.setChapterNameString(item: Chapter?) {
    item?.let {
        val name:String = "Chapter " + item.chapterNum
        text = name

        if(item.chapterNum == 1) {
            setTextColor(ContextCompat.getColor(context, R.color.tt_monday))
        }

        else if(item.chapterNum == 2){
            setTextColor(ContextCompat.getColor(context, R.color.tt_thursday))
        }

        else if(item.chapterNum == 3){
            setTextColor(ContextCompat.getColor(context, R.color.tt_wednesday))
        }

        else if(item.chapterNum == 4){
            setTextColor(ContextCompat.getColor(context, R.color.design_default_color_primary))
        }

        else if(item.chapterNum == 5) {
            setTextColor(ContextCompat.getColor(context, R.color.tt_friday))
        }

    }
}

@BindingAdapter("chapterDescString")
fun TextView.setChapterDescString(item: Chapter?) {
    item?.let {
        text = item.chapterDesc

        if(item.chapterNum == 1) {
            setTextColor(ContextCompat.getColor(context, R.color.tt_monday))
        }

        else if(item.chapterNum == 2){
            setTextColor(ContextCompat.getColor(context, R.color.tt_thursday))
        }

        else if(item.chapterNum == 3){
            setTextColor(ContextCompat.getColor(context, R.color.tt_wednesday))
        }

        else if(item.chapterNum == 4){
            setTextColor(ContextCompat.getColor(context, R.color.design_default_color_primary))
        }

        else if(item.chapterNum == 5) {
            setTextColor(ContextCompat.getColor(context, R.color.tt_friday))
        }
    }
}

@BindingAdapter("linel")
fun LinearLayout.setLinel(item: Chapter?) {
    item?.let {

        if(item.chapterNum == 1) {
            background = ContextCompat.getDrawable(context, R.color.tt_monday)
        }

        else if(item.chapterNum == 2){
            background = ContextCompat.getDrawable(context, R.color.tt_thursday)
        }

        else if(item.chapterNum == 3){
            background = ContextCompat.getDrawable(context, R.color.tt_wednesday)
        }

        else if(item.chapterNum == 4){
            background = ContextCompat.getDrawable(context, R.color.design_default_color_primary)
        }

        else if(item.chapterNum == 5){
            background = ContextCompat.getDrawable(context, R.color.tt_friday)
        }


    }
}