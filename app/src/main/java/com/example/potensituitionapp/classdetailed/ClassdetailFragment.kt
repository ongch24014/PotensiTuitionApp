package com.example.potensituitionapp.classdetailed


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.potensituitionapp.Main.MainmenuFragment

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentClassdetailBinding
import kotlinx.android.synthetic.main.fragment_classdetail.*

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

        val application = requireNotNull(this.activity).application
        val arguments = ClassdetailFragmentArgs.fromBundle(arguments)
        val class_ID = arguments.classId

        val dataSource = TuitionDatabase.getInstance(application).chapterDatabaseDao

        Log.i("s",class_ID)

        binding.className.text = class_ID

        return binding.root
    }


}

