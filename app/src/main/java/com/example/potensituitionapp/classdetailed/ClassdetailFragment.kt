package com.example.potensituitionapp.classdetailed


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentClassdetailBinding

/**
 * A simple [Fragment] subclass.
 */
class ClassdetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentClassdetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_classdetail, container, false)

        return binding.root
    }


}

