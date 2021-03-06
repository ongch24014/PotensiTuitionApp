package com.example.potensituitionapp.teacherpage


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

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

        (activity as AppCompatActivity).supportActionBar?.title = ""

        val teacherclassViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(TeacherclassViewModel::class.java)

        val adapter = TeacherclassAdapter(TimetableListener { nightId ->
            teacherclassViewModel.onClassDetailClicked(nightId)
        })

        teacherclassViewModel.navigateToDetailClass.observe(this, Observer { night -> night?.let {
            var classid:String = night.classID
            Log.i("Hey",night.classVenue+night.classDay)
            this.findNavController().navigate(
                TeacherclassFragmentDirections
                    .actionTeacherclassFragmentToTeacherdetailclassFragment(classid,night.classVenue,night.classDay))
            teacherclassViewModel.onClassDetailNavigated()

        } })

        binding.timetableList.adapter = adapter

        teacherclassViewModel.teacherclass.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.btnAdd.setOnClickListener {
            this.findNavController().navigate(
                TeacherclassFragmentDirections
                    .actionTeacherclassFragmentToTeachernewclassFragment()
            )
        }

        return binding.root
    }


}
