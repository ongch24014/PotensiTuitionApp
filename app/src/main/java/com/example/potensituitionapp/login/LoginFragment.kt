package com.example.potensituitionapp.login



import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.MainActivity.Companion.role
import com.example.potensituitionapp.MainActivity.Companion.user_namename
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Student
import com.example.potensituitionapp.database.Teacher
import com.example.potensituitionapp.database.TeacherDao
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */

class LoginFragment : Fragment() {

    private var username:String = ""
    private var password:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (activity as AppCompatActivity).supportActionBar?.title = "Login"

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        //Database
        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).studentDatabaseDao
        val dataSource1 = TuitionDatabase.getInstance(application).teacherDatabaseDao

        (activity as AppCompatActivity).supportActionBar?.title = "Login"

        //buttonClicked
        binding.LoginButton.setOnClickListener{

            username = usernameText.text.toString()
            password = passwordText.text.toString()

            this.hideKeyboard()

            var stud: Student? = dataSource.getStudent(username)
            var teach: Teacher? = dataSource1.getTeacher(username)

            if(stud == null && teach == null){
                Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()
                Log.i("Result","No user found")
            }
            else{
                if(stud!=null){
                    if(stud!!.password.equals(password)){
                        Toast.makeText(activity, R.string.login_success, Toast.LENGTH_SHORT).show()

                        loggedUser = stud.studentID
                        role = "Student"
                        user_namename = stud.name
                        Log.i("Result","Successfully logged in")

                        navigateToMainPage()
                    }

                    else{
                        Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()

                        Log.i("Result","Invalid password")
                    }
                }

                else{
                    if(teach!!.password.equals(password)){
                        Toast.makeText(activity, R.string.login_success, Toast.LENGTH_SHORT).show()

                        loggedUser = teach.teacherID
                        role = "Teacher"

                        navigateToTeacherPage()
                    }

                    else{
                        Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()

                        Log.i("Result","Invalid password")
                    }
                }



            }
        }
        return binding.root
    }

    private fun navigateToMainPage(){

        (activity as MainActivity).setNavVisible()
        this.findNavController().navigate(
            LoginFragmentDirections
                .actionLoginFragmentToMainmenuFragment())
    }

    private fun navigateToTeacherPage(){
        this.findNavController().navigate(
            LoginFragmentDirections
                .actionLoginFragmentToTeachermainFragment())
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



