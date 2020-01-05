package com.example.potensituitionapp.teachernewclass


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentTeachernewclassBinding

/**
 * A simple [Fragment] subclass.
 */
class TeachernewclassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeachernewclassBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teachernewclass, container, false)



        return binding.root
    }


}
