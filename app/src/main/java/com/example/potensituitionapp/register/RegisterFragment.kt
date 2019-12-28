package com.example.potensituitionapp.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Student
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    private var username:String = ""
    private var password:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Register"

        // Inflate the layout for this fragment
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_register,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).studentDatabaseDao
        val viewModelFactory = RegisterViewModelFactory(dataSource, application)


        val loginViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(RegisterViewModel::class.java)

        binding.registerViewModel = loginViewModel

        binding.setLifecycleOwner(this)

        var stud:Student = loginViewModel.getStud()

        binding.txtViewData.text = stud.name + stud.password


        binding.btnRegister.setOnClickListener{
            username = binding.txtName.text.toString()
            password = binding.txtPassword.text.toString()

            var stud = Student()

            stud.name = username
            stud.password = password

            loginViewModel.insert(stud)

            backToHome()}

        return binding.root

    }

    fun backToHome(){
        this.findNavController().navigate(
            RegisterFragmentDirections
                .actionRegisterFragmentToLoginFragment())

    }


}
