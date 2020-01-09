package com.example.potensituitionapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.potensituitionapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.ui.AppBarConfiguration


class MainActivity : AppCompatActivity() {

    private var notificationManager:NotificationManager? = null

    lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    companion object {
        var loggedUser = ""
        var role = ""
        var user_namename = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel("com.example.potensituitionapp",
            "Notifcation","Demo Testing")


        navController = this.findNavController(R.id.myNavHostFragment)
        bottomNav.setupWithNavController(navController)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        loggedUser = sharedPreferences.getString("loggedUser","")
        role = sharedPreferences.getString("role","")
        user_namename = sharedPreferences.getString("user_namename","")


        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.mainmenuFragment,
            R.id.titleFragment,
            R.id.teachermainFragment
        ).build()

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)


//        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

    }

    private fun createNotificationChannel(id:String,name:String,description:String){
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id,name,importance)
        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100,200,300,400,500,400,300,200,400)

        notificationManager?.createNotificationChannel(channel)

    }

    fun sendNotification(view:View){

        val notificationId = 101
        val channelId = "com.example.potensituitionapp"

        val notfication = Notification.Builder(this@MainActivity, channelId)
            .setContentTitle("Demo Notification")
            .setContentText("Hi Buddy")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setChannelId(channelId)
            .build()

        notificationManager?.notify(notificationId,notfication)
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
        role = sharedPreferences.getString("role","")
        user_namename = sharedPreferences.getString("user_namename","")

        super.onResume()
    }

    override fun onPause() {
        with(sharedPreferences.edit()){
            putString("loggedUser", loggedUser)
            putString("role", role)
            putString("user_namename", user_namename)
            commit()
        }
        super.onPause()
    }

    override fun onStop() {
        with(sharedPreferences.edit()){
            putString("loggedUser", loggedUser)
            putString("role", role)
            putString("user_namename", user_namename)
            commit()
        }
        super.onStop()
    }
}
