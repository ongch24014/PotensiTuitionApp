package com.example.potensituitionapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.databinding.FragmentTitleBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.loginButton.setOnClickListener{view : View ->

            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToLoginFragment())}

        binding.RegisterButton.setOnClickListener{view : View ->

            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRegisterFragment())}

        (activity as AppCompatActivity).supportActionBar?.title = "Potensi Tuition App"


        (activity as MainActivity).setNavInvisible()


        if(loggedUser.equals("")){
            (activity as MainActivity).setNavInvisible()
        }
        else{
            (activity as MainActivity).setNavVisible()
            findNavController().navigate(R.id.mainmenuFragment)
        }

        return binding.root
    }

    @Override
    fun onBackPressed(){


    }


}
