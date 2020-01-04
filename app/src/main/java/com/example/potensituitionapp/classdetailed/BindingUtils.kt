package com.example.potensituitionapp.classdetailed

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.potensituitionapp.database.Chapter

@BindingAdapter("chapterNameString")
fun TextView.setChapterNameString(item: Chapter?) {
    item?.let {
        text = item.classID
    }
}

@BindingAdapter("chapterDescString")
fun TextView.setChapterDescString(item: Chapter?) {
    item?.let {
        text = item.chapterDesc
    }
}