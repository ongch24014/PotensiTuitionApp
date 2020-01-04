package com.example.potensituitionapp.chapter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentChapterBinding

/**
 * A simple [Fragment] subclass.
 */
class ChapterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentChapterBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_chapter, container, false
        )

        val application = requireNotNull(this.activity).application
        val arguments = ChapterFragmentArgs.fromBundle(arguments)
        val class_ID:Int = arguments.chapternum

        val title:String = "Chapter " + class_ID

        (activity as AppCompatActivity).supportActionBar?.title = title





        return binding.root
    }


}
