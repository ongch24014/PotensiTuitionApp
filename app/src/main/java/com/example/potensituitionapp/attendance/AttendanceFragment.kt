package com.example.potensituitionapp.attendance

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import com.example.potensituitionapp.R
import com.example.potensituitionapp.addcourse.AddcourseViewModel
import com.example.potensituitionapp.addcourse.AddcourseViewModelFactory
import com.example.potensituitionapp.database.Course
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.*

class AttendanceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_attendance, container, false)
        return binding.root
    }

    fun init(){
        
    }
}