package com.example.pairassginment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pairassginment.databinding.ActivityMainBinding
import com.example.pairassginment.student.Dashboard
import com.example.pairassginment.student.ListOfThreeTopic
import com.example.pairassginment.supervisor.DashboardSupervisor

class MainActivity : AppCompatActivity(){
    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        bindingMain.signInButton.setOnClickListener{
            val intent = Intent(this, DashboardSupervisor::class.java)
            startActivity(intent)
        }
    }

}