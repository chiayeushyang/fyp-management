package com.example.pairassginment.supervisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pairassginment.R
import com.example.pairassginment.databinding.ActivityDashboardSupervisorBinding
import com.example.pairassginment.databinding.ActivityMainBinding
import com.example.pairassginment.databinding.FragmentViewAndEditMarkBinding

class DashboardSupervisor : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardSupervisorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardSupervisorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId){

                R.id.Home -> replaceFragment(Home())
                R.id.Student -> replaceFragment(StudentList())
                R.id.Assignment -> replaceFragment(GiveMarkAndApprove())

                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}