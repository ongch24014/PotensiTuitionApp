package com.example.potensituitionapp.teacherpage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentTeacherclassBinding

/**
 * A simple [Fragment] subclass.
 */
class TeacherclassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeacherclassBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teacherclass, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource1 = TuitionDatabase.getInstance(application).timetableDatabaseDao
        val viewModelFactory = TeacherclassViewModelFactory(dataSource1, application)

        val teacherclassViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(TeacherclassViewModel::class.java)


        return binding.root
    }


}
