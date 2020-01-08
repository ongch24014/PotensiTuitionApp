package com.example.potensituitionapp.attendance

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Attendance
import com.example.potensituitionapp.database.ClassRecord
import com.example.potensituitionapp.database.Enrollment
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding
import kotlinx.android.synthetic.main.fragment_attendance.*


open class AttendanceFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attendance, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).classRecordDatabaseDao
        val db = TuitionDatabase.getInstance(application).attendanceDatabaseDao
        var num1:String = ""
        var num2:String = ""
        var num3:String = ""
        var num4:String = ""
        var code:String = ""

        binding.txtNum1.requestFocus()

        fun checkCode(){

            this.hideKeyboard()

            num1 = txtNum1.text.toString()
            num2 = txtNum2.text.toString()
            num3 = txtNum3.text.toString()
            num4 = txtNum4.text.toString()

            code = num1 + num2 + num3 + num4

            var cr:ClassRecord = dataSource.getClassbyCode(code)

            if(cr == null){
                Toast.makeText(this.context,"Invalid code!",Toast.LENGTH_SHORT).show()
            }

            else{

                var enrol:Enrollment = dataSource.getEnrollment(cr.classID,loggedUser)

                if(enrol == null){
                    Toast.makeText(this.context,"Course not registered!",Toast.LENGTH_SHORT).show()
                }

                else{
                    var attendance:Attendance = dataSource.getAttendanceClass(cr.classID, loggedUser)

                    if(attendance == null){

                        var newAttendance = Attendance()
                        newAttendance.classID = cr.classID
                        newAttendance.studentID = loggedUser
                        newAttendance.status = "Present"

                        db.insert(newAttendance)

                        Toast.makeText(this.context,"Successfully signed in!",Toast.LENGTH_SHORT).show()
                    }

                    else{
                        Toast.makeText(this.context,"You have taken your attendance!",Toast.LENGTH_SHORT).show()

                    }

                }

            }

            binding.txtNum1.setText("")
            binding.txtNum2.setText("")
            binding.txtNum3.setText("")
            binding.txtNum4.setText("")

            binding.txtNum1.requestFocus()
        }




        binding.txtNum1.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {
                if(s.length > 0){
                    binding.txtNum2.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

        })

        binding.txtNum2.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {
                if(s.length > 0){
                    binding.txtNum3.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

        })

        binding.txtNum3.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {
                if(s.length > 0){
                    binding.txtNum4.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

        })

        binding.txtNum4.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {
                if(s.length > 0){
                    checkCode()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

        })

        return binding.root
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}