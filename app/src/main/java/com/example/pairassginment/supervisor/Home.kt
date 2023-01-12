package com.example.pairassginment.supervisor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pairassginment.R
import com.example.pairassginment.databinding.ActivityDashboardSupervisorBinding
import com.example.pairassginment.databinding.FragmentHomeBinding
import com.example.pairassginment.student.itemRecycleAdapter
import com.example.pairassginment.student.objectClass.HomeItems
import com.example.pairassginment.student.objectClass.ThreeTopicsItem
import com.example.pairassginment.supervisor.recycleAdapter.SupervisorAdapter

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
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
//       if (view is RecyclerView)  {

//            with(view) {
                view.findViewById<RecyclerView>(R.id.home_RV).layoutManager=LinearLayoutManager(context)
                view.findViewById<RecyclerView>(R.id.home_RV).adapter=SupervisorAdapter(itemsArray)
//            }
//        }
        return view
    }

    fun getItems() {
        itemsArray = ArrayList();
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

}