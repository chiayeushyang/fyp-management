package com.example.pairassginment.coordinator

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pairassginment.coordinator.objectClass.BatchData
import com.example.pairassginment.databinding.ActivitySaveViewBatchBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class SaveViewBatch : AppCompatActivity() {
    private var datePickerDialog: DatePickerDialog? = null
    private var dateBatchButton: Button? = null
    private var dateTopicBeginButton: Button? = null
    private var dateProposalPPTBeginButton: Button? = null
    private var dateProposalBeginButton: Button? = null
    private var dateFinalDraftBeginButton: Button? = null
    private var dateFinalPPTBeginButton: Button? = null
    private var dateFinalThesisBeginButton: Button? = null
    private var datePosterBeginButton: Button? = null

    private var dateTopicDeadlineButton: Button? = null
    private var dateProposalPPTDeadlineButton: Button? = null
    private var dateProposalDeadlineButton: Button? = null
    private var dateFinalDraftDeadlineButton: Button? = null
    private var dateFinalPPTDeadlineButton: Button? = null
    private var dateFinalThesisDeadlineButton: Button? = null
    private var datePosterDeadlineButton: Button? = null

    private var tempDatePickerBtn: Button? = null
    private var submissionDetail: BatchData? = null
    private var backBtn : Button? = null
    private var saveBtn : Button? = null

    private var binding: ActivitySaveViewBatchBinding? = null
    private var batchDetail: BatchData = BatchData()

    private var mDB: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveViewBatchBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        backBtn = binding!!.backBtn
        saveBtn = binding!!.saveBtn

        submissionDetail = intent.getParcelableExtra("item_click")

        initDataPicker()
        dateBatchButton = binding!!.datePickerBatchBtn
        dateTopicBeginButton = binding!!.dpTopicBeginBtn
        dateProposalPPTBeginButton = binding!!.dpProposalPptBeginBtn
        dateProposalBeginButton = binding!!.dpProposalBeginBtn
        dateFinalDraftBeginButton = binding!!.dpFinalDraftBeginBtn
        dateFinalPPTBeginButton = binding!!.dpFinalPptBeginBtn
        dateFinalThesisBeginButton = binding!!.dpFinalThesisBeginBtn
        datePosterBeginButton = binding!!.dpPosterBeginBtn

        dateTopicDeadlineButton = binding!!.dpTopicDeadlineBtn
        dateProposalPPTDeadlineButton = binding!!.dpProposalPptDeadlineBtn
        dateProposalDeadlineButton = binding!!.dpProposalDeadlineBtn
        dateFinalDraftDeadlineButton = binding!!.dpFinalDraftDeadlineBtn
        dateFinalPPTDeadlineButton = binding!!.dpFinalPptDeadlineBtn
        dateFinalThesisDeadlineButton = binding!!.dpFinalThesisDeadlineBtn
        datePosterDeadlineButton = binding!!.dpPosterDeadlineBtn

        setEachDatePickerOnClickListener()
        setDatePickerReady()
        setBtnOnClickListener()
    }

    private fun setDatePickerReady(){

        if(submissionDetail != null){
            binding!!.saveBtn.text = "UPDATE"

            dateBatchButton!!.text = submissionDetail!!.intake_mnt_year
            dateTopicBeginButton!!.text = submissionDetail!!.topics_begin
            dateProposalPPTBeginButton!!.text = submissionDetail!!.proposal_ppt_begin
            dateProposalBeginButton!!.text = submissionDetail!!.proposal_begin
            dateFinalDraftBeginButton!!.text = submissionDetail!!.final_draft_begin
            dateFinalPPTBeginButton!!.text = submissionDetail!!.final_ppt_begin
            dateFinalThesisBeginButton!!.text = submissionDetail!!.final_thesis_begin
            datePosterBeginButton!!.text = submissionDetail!!.poster_begin

            dateTopicDeadlineButton!!.text = submissionDetail!!.topics_deadline
            dateProposalPPTDeadlineButton!!.text = submissionDetail!!.proposal_ppt_deadline
            dateProposalDeadlineButton!!.text = submissionDetail!!.proposal_deadline
            dateFinalDraftDeadlineButton!!.text = submissionDetail!!.final_draft_deadline
            dateFinalPPTDeadlineButton!!.text = submissionDetail!!.final_ppt_deadline
            dateFinalThesisDeadlineButton!!.text = submissionDetail!!.final_thesis_deadline
            datePosterDeadlineButton!!.text = submissionDetail!!.poster_deadline
        }
    }

    private fun setBtnOnClickListener(){
        val intentBack = Intent(this, Dashboard::class.java)

        backBtn!!.setOnClickListener {
            intentBack.putExtra("from_view", "batch")
            startActivity(intentBack)
            finish()
        }

        saveBtn!!.setOnClickListener {
            updateOntoDB()
        }

    }

    private fun updateOntoDB(){

        retrieveData()
        Log.d("adsfadf", batchDetail.toString())

        val batchDetailDB = hashMapOf<String, Any>(
            "Intake_MntYear" to batchDetail.intake_mnt_year.toString(),
            "Topics_Begin" to batchDetail.topics_begin.toString(),
            "Proposal_PPT_Begin" to batchDetail.proposal_ppt_begin.toString(),
            "Proposal_Begin" to batchDetail.proposal_begin.toString(),
            "Final_Draft_Begin" to batchDetail.final_draft_begin.toString(),
            "Final_PPT_Begin" to batchDetail.final_ppt_begin.toString(),
            "Final_Thesis_Begin" to batchDetail.final_thesis_begin.toString(),
            "Poster_Begin" to batchDetail.poster_begin.toString(),
            "Topics_Deadline" to batchDetail.topics_deadline.toString(),
            "Proposal_PPT_Deadline" to batchDetail.proposal_ppt_deadline.toString(),
            "Proposal_Deadline" to batchDetail.proposal_deadline.toString(),
            "Final_Draft_Deadline" to batchDetail.final_draft_deadline.toString(),
            "Final_PPT_Deadline" to batchDetail.final_ppt_deadline.toString(),
            "Final_Thesis_Deadline" to batchDetail.final_thesis_deadline.toString(),
            "Poster_Deadline" to batchDetail.poster_deadline.toString()
        )

        val batch_collection = mDB.collection("Batch")


        if(submissionDetail != null){
            batch_collection
                .document(submissionDetail!!.document_id!!)
                .update(batchDetailDB)
                .addOnSuccessListener {
                    val intentSave = Intent(this, Dashboard::class.java)
                    intentSave.putExtra("from_view", "batch")
                    intentSave.putExtra("message", "Update Successfully")
                    startActivity(intentSave)
                    finish()
                }

        }else{
            batch_collection
                .document()
                .set(batchDetailDB)
                .addOnSuccessListener {
                    val intentSave = Intent(this, Dashboard::class.java)
                    intentSave.putExtra("from_view", "batch")
                    intentSave.putExtra("message", "Create Successfully")
                    startActivity(intentSave)
                    finish()
                }
        }
    }

    private fun retrieveData(){
        batchDetail.intake_mnt_year = dateBatchButton!!.text.toString()
        batchDetail.topics_begin = dateTopicBeginButton!!.text.toString()
        batchDetail.proposal_ppt_begin = dateProposalPPTBeginButton!!.text.toString()
        batchDetail.proposal_begin = dateProposalBeginButton!!.text.toString()
        batchDetail.final_draft_begin = dateFinalDraftBeginButton!!.text.toString()
        batchDetail.final_ppt_begin = dateFinalPPTBeginButton!!.text.toString()
        batchDetail.final_thesis_begin = dateFinalThesisBeginButton!!.text.toString()
        batchDetail.poster_begin = datePosterBeginButton!!.text.toString()
        batchDetail.topics_deadline = dateTopicDeadlineButton!!.text.toString()
        batchDetail.proposal_ppt_deadline = dateProposalPPTDeadlineButton!!.text.toString()
        batchDetail.proposal_deadline = dateProposalDeadlineButton!!.text.toString()
        batchDetail.final_draft_deadline = dateFinalDraftDeadlineButton!!.text.toString()
        batchDetail.final_ppt_deadline = dateFinalPPTDeadlineButton!!.text.toString()
        batchDetail.final_thesis_deadline = dateFinalThesisDeadlineButton!!.text.toString()
        batchDetail.poster_deadline = datePosterDeadlineButton!!.text.toString()
    }

    private fun setEachDatePickerOnClickListener(){
        dateBatchButton!!.setOnClickListener {
            tempDatePickerBtn = dateBatchButton
            openDatePicker(dateBatchButton)
        }

        dateTopicBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateTopicBeginButton
            openDatePicker(dateTopicBeginButton)
        }

        dateProposalPPTBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateProposalPPTBeginButton
            openDatePicker(dateProposalPPTBeginButton)
        }

        dateProposalBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateProposalBeginButton
            openDatePicker(dateProposalBeginButton)
        }

        dateFinalDraftBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalDraftBeginButton
            openDatePicker(dateFinalDraftBeginButton)
        }

        dateFinalPPTBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalPPTBeginButton
            openDatePicker(dateFinalPPTBeginButton)
        }

        dateFinalThesisBeginButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalThesisBeginButton
            openDatePicker(dateFinalThesisBeginButton)
        }

        datePosterBeginButton!!.setOnClickListener {
            tempDatePickerBtn = datePosterBeginButton
            openDatePicker(datePosterBeginButton)
        }

        dateTopicDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateTopicDeadlineButton
            openDatePicker(dateTopicDeadlineButton)
        }

        dateProposalPPTDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateProposalPPTDeadlineButton
            openDatePicker(dateProposalPPTDeadlineButton)
        }

        dateProposalDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateProposalDeadlineButton
            openDatePicker(dateProposalDeadlineButton)
        }

        dateFinalDraftDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalDraftDeadlineButton
            openDatePicker(dateFinalDraftDeadlineButton)
        }

        dateFinalPPTDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalPPTDeadlineButton
            openDatePicker(dateFinalPPTDeadlineButton)
        }

        dateFinalThesisDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = dateFinalThesisDeadlineButton
            openDatePicker(dateFinalThesisDeadlineButton)
        }

        datePosterDeadlineButton!!.setOnClickListener {
            tempDatePickerBtn = datePosterDeadlineButton
            openDatePicker(datePosterDeadlineButton)
        }

    }

    private fun initDataPicker(){
        val dateSetListener =
            OnDateSetListener { datePicker, year, month, day ->
                var month = month
                month = month + 1
                val date: String = makeDateString(day, month, year)
                tempDatePickerBtn!!.text = date

            }

        val cal: Calendar = Calendar.getInstance()
        val year: Int = cal.get(Calendar.YEAR)
        val month: Int = cal.get(Calendar.MONTH)
        val day: Int = cal.get(Calendar.DAY_OF_MONTH)

        val style: Int = AlertDialog.THEME_HOLO_LIGHT

        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
        //datePi
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        val month = getMonthFormat(month)

        return day.toString() +" "+ month + " " + year
    }

    private fun getMonthFormat(month: Int): String {
        if (month == 1) return "JAN"
        if (month == 2) return "FEB"
        if (month == 3) return "MAR"
        if (month == 4) return "APR"
        if (month == 5) return "MAY"
        if (month == 6) return "JUN"
        if (month == 7) return "JUL"
        if (month == 8) return "AUG"
        if (month == 9) return "SEP"
        if (month == 10) return "OCT"
        if (month == 11) return "NOV"
        return if (month == 12) "DEC" else "JAN"

        //default should never happen
    }

    fun openDatePicker(view: View?) {
        datePickerDialog!!.show()
    }
}