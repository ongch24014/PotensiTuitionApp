package com.example.potensituitionapp.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding
import com.google.android.material.tabs.TabLayout


open class AttendanceFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attendance, container, false)

        return binding.root
    }
}