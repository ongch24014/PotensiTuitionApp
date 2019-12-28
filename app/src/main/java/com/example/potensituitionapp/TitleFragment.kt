package com.example.potensituitionapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.potensituitionapp.databinding.FragmentTitleBinding

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

        return binding.root
    }


}
