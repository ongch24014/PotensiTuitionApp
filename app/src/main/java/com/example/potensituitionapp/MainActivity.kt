package com.example.potensituitionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.potensituitionapp.Main.MainmenuFragment
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.ActivityMainBinding
import com.example.potensituitionapp.login.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mainmenu.*
import android.R.attr.tag
import android.content.Context
import android.content.SharedPreferences
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.navigation.fragment.findNavController


class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    companion object {
        var loggedUser = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.myNavHostFragment)
        bottomNav.setupWithNavController(navController)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        loggedUser = sharedPreferences.getString("loggedUser","")

        NavigationUI.setupActionBarWithNavController(this,navController)

//        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

    }

    override fun onSupportNavigateUp(): Boolean {
        //val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,null)
    }

    fun setNavInvisible(){
        var bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNav.visibility = View.GONE
    }

    fun setNavVisible(){
        var bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNav.visibility = View.VISIBLE
    }

    override fun onResume() {
        loggedUser = sharedPreferences.getString("loggedUser","")
        super.onResume()
    }

    override fun onPause() {
        with(sharedPreferences.edit()){
            putString("loggedUser", loggedUser)
            commit()
        }
        super.onPause()
    }

    override fun onStop() {
        with(sharedPreferences.edit()){
            putString("loggedUser", loggedUser)
            commit()
        }
        super.onStop()
    }
}
