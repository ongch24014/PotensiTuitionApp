package com.example.potensituitionapp.chapter


import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentNotesBinding

/**
 * A simple [Fragment] subclass.
 */
class NotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNotesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_notes, container, false
        )

        val arguments = NotesFragmentArgs.fromBundle(arguments)
        val pdf:String = arguments.notepath

        var pic: String = pdf
        var pic_id:Int = resources.getIdentifier(pic,"drawable",context!!.packageName)
        var drawable: Drawable = resources.getDrawable(pic_id)
        binding.imgNotes.setImageDrawable(drawable)

        return binding.root
    }


}
