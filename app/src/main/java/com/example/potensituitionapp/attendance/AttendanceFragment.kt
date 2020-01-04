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
import com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener
import kotlinx.android.synthetic.main.fragment_attendance.*


class AttendanceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_attendance, container, false)
        return binding.root
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                
            }
        })
    }
}
