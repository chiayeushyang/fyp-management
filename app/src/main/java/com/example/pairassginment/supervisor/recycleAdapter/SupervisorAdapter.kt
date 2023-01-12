package com.example.pairassginment.supervisor.recycleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pairassginment.R
import com.example.pairassginment.databinding.CardLayoutBinding
import com.example.pairassginment.databinding.SupervisorDashboardRecycleViewRowBinding
import com.example.pairassginment.student.itemRecycleAdapter
import com.example.pairassginment.student.objectClass.HomeItems

class SupervisorAdapter(val items: ArrayList<HomeItems>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private lateinit var mListener:  SupervisorAdapter.onItemClickListner

//    private var titles = arrayOf("Arduino of Solar")
//    private var images = intArrayOf(R.drawable.ic_baseline_check_24)

//    fun setOnClickListener(listener: SupervisorAdapter.onItemClickListner) {
//        mListener = listener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.supervisor_dashboard_recycle_view_row, parent, false)
        return ViewHolder(itemView)
//        val binding = SupervisorDashboardRecycleViewRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return SupervisorAdapter.ViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.supervisor_student_list_row,
//                parent,
//                false
//            ), binding
//        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.itemImage.setImageResource(R.drawable.ic_baseline_check_24)
            holder.itemTitle.setText(items[position].homeTitle)
        }
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.status_img)
            itemTitle = itemView.findViewById(R.id.student_title_tv)
        }
    }
}