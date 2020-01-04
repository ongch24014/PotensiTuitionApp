package com.example.potensituitionapp.chapter


import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Chapter
import com.example.potensituitionapp.database.TuitionDatabase
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
        val dataSource = TuitionDatabase.getInstance(application).chapterDatabaseDao
        val chapterNum:Int = arguments.chapternum
        val classId:String = arguments.classId

        val title:String = "Chapter " + chapterNum

        (activity as AppCompatActivity).supportActionBar?.title = title

        var chap: Chapter = dataSource.getChapter(classId,chapterNum)

        binding.txtDesc.text = title + " : " + chap.chapterDesc

        binding.btnNotes.setOnClickListener{
            this.findNavController().navigate(
                ChapterFragmentDirections.
                    actionChapterFragmentToNotesFragment(chap.chapterPDF))
        }

        binding.btnAudio.setOnClickListener{
            this.findNavController().navigate(
                ChapterFragmentDirections.
                    actionChapterFragmentToAudioFragment(chap.chapterAudio))
        }





        return binding.root
    }


}
