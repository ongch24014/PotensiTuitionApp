package com.example.potensituitionapp.timetable


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentTimetableBinding
import com.example.potensituitionapp.register.RegisterViewModelFactory
import java.sql.Date

/**
 * A simple [Fragment] subclass.
 */
class TimetableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Timetable"

        // Inflate the layout for this fragment
        val binding: FragmentTimetableBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_timetable,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).timetableDatabaseDao
        val viewModelFactory = TimetableViewModelFactory(dataSource, application)


        val timetableViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(TimetableViewModel::class.java)

        val adapter = TimetableAdapter()

        timetableViewModel.timetables.observe(viewLifecycleOwner, Observer{
            timetableViewModel.timetables.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.data = it
                }
            })
        })

        binding.timetableList.adapter = adapter




//
//        if(adapter.itemCount == 0){
//            Log.i("s","shit")
//            binding.timetableList.visibility = View.GONE
//        }
//
//        else{
//
//        }
//
//        if(adapter1.itemCount == 0){
//            binding.timetableListT.visibility = View.GONE
//        }
//
//        else{
//            binding.timetableListT.adapter = adapter1
//        }

        binding.timetableViewModel = timetableViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }


}
