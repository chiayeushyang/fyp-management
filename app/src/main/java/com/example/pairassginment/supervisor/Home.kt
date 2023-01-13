package com.example.pairassginment.supervisor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pairassginment.R
import com.example.pairassginment.databinding.FragmentHomeBinding
import com.example.pairassginment.student.itemRecycleAdapter
import com.example.pairassginment.supervisor.`object`.HomeItems
import com.example.pairassginment.supervisor.recycleAdapter.SupervisorAdapter

class Home : Fragment(), SupervisorAdapter.OnItemClickListener {
    private lateinit var itemsArray: ArrayList<HomeItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        getItems()
        Log.d("asd2", view.toString())

                view.findViewById<RecyclerView>(R.id.home_RV).layoutManager=LinearLayoutManager(context)
                view.findViewById<RecyclerView>(R.id.home_RV).adapter=SupervisorAdapter(itemsArray, this)

        return view
    }

    override fun onItemClick(position: Int) {

    }

    fun getItems() {
        itemsArray = ArrayList();
        itemsArray.add(HomeItems("Arduinogggggggggggggggggggggggggggggggggggggggggggggggggggg", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solarggggggggggggggggggggggggggggggggggggggggggggggggggg", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Arduino", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Solar", "ic_baseline_close_24"))
        itemsArray.add(HomeItems("Car", "ic_baseline_home_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera4", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_24"))
        itemsArray.add(HomeItems("Camera", "ic_baseline_check_last"))
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout, fragment)
        fragmentTransaction?.commit()
    }
}