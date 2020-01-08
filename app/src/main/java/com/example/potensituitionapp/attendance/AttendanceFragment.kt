package com.example.potensituitionapp.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_attendance.*


open class AttendanceFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attendance, container, false)
        binding.button.setOnClickListener(){
            CompareSign()
        }
        return binding.root
    }

    fun CompareSign(){
        val firstCode = editText.text
        val secandCode = editText5.text
        val thirdCode = editText6.text
        val fouthCode = editText7.text
        val AttendanceCode = firstCode

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).classRecordDatabaseDao

        if(dataSource.getClassRecord("").equals(AttendanceCode)){
            Toast.makeText(null,"Had Been Success Sign In",Toast.LENGTH_LONG)
        }
    }
}