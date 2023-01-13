package com.example.pairassginment.supervisor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pairassginment.R
import com.example.pairassginment.supervisor.`object`.StudWorkClass
import com.example.pairassginment.supervisor.recycleAdapter.StudWorkAdapter


class StudentWork : Fragment(), StudWorkAdapter.OnItemClickListener {

    private lateinit var itemsArray: ArrayList<StudWorkClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_work, container, false)
        getItems()

        view.findViewById<RecyclerView>(R.id.studWork_rv).layoutManager =
            LinearLayoutManager(context)
        view.findViewById<RecyclerView>(R.id.studWork_rv).adapter =
            StudWorkAdapter(itemsArray, this)

        return view
    }

    override fun onItemClick(position: Int) {
        val type = itemsArray[position].itemImage.toString()

        when (type) {
            "ppt" -> replaceFragment(pptApprove())
            "txt" -> replaceFragment(GiveMarkAndApprove())
            "thesis" -> replaceFragment(ThesisApproveAndMark())
            else -> replaceFragment(TitleApprove())
        }
    }

    fun getItems() {
        itemsArray = ArrayList();

        itemsArray.add(StudWorkClass("Arduino of thesis", "thesis", "10/60", "2023-1-1", "2023-1-2"))
        itemsArray.add(StudWorkClass("Arduino of ppt", "ppt", "10/60", "2023-1-1", "2023-1-2"))
        itemsArray.add(StudWorkClass("Arduino of proposal", "txt", "10/60", "2023-1-1", "2023-1-2"))
        itemsArray.add(StudWorkClass("Arduino of title1", "idea", "10/60", "2023-1-1", "2023-1-2"))
        itemsArray.add(StudWorkClass("Arduino of title2", "idea", "10/60", "2023-1-1", "2023-1-2"))
        itemsArray.add(StudWorkClass("Arduino of title3", "idea", "10/60", "2023-1-1", "2023-1-2"))

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout, fragment)
        fragmentTransaction?.commit()
    }

}
