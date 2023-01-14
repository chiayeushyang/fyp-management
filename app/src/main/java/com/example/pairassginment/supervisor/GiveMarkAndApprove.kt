package com.example.pairassginment.supervisor

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pairassginment.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import com.skydoves.balloon.showAlignTop


class GiveMarkAndApprove : Fragment() {
    private var mDB: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val uid:String = FirebaseAuth.getInstance().currentUser!!.uid;
    private lateinit var storageReference: StorageReference
    private lateinit var ref: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_give_mark_and_approve, container, false)
        val mark = view.findViewById<EditText>(R.id.mark_et)
        val button = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val approve = view.findViewById<Button>(R.id.button2)
        val resubmit = view.findViewById<Button>(R.id.button3)
        val save = view.findViewById<Button>(R.id.button4)
        val download = view.findViewById<Button>(R.id.button)

        download.setOnClickListener() {
            download()
        }

        val balloon = createBalloon(requireContext()) {
            setArrowSize(10)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(BalloonSizeSpec.WRAP)
            setArrowPosition(0.5f)
            setCornerRadius(4f)
            setArrowAlignAnchorPadding(10)
            setAlpha(0.9f)
            setPadding(10)
//            setIsVisibleOverlay(true)
//            setOverlayColorResource(R.color.balloon_overlay)
//            setOverlayPadding(6f)
//            setOverlayPaddingColorResource(R.color.colorPrimary)
//            setBalloonOverlayAnimation(BalloonOverlayAnimation.FADE)
//            setDismissWhenOverlayClicked(false)
            setText("Laporan proposal (P01, C4(analisis)) : 5%  pengetahuan\n" +
                    "\n" +
                    "Perlu mempunyai elemen berikut:\n" +
                    "•\tPengenalan tentang projek dinyatakan dengan jelas  \n" +
                    "•\tPernyataan masalah dinyatakan dengan jelas\n" +
                    "•\tKajian literatur adalah relevan dengan pernyataan masalah\n" +
                    "•\tObjektif yang hendak dicapai selaras dengan pernyataan masalah\n" +
                    "•\tSkop projek bersesuaian dengan tahap prasiswazah \n" +
                    "•\tJangkaan hasil yang boleh dicapai\n" +
                    "•\tPerancangan projek dirangka dengan tersusun")
            setTextColorResource(R.color.black)
            setBackgroundColorResource(R.color.tooltip_bg)
            setBalloonAnimation(BalloonAnimation.ELASTIC)
            setLifecycleOwner(lifecycleOwner)

        }

        button.setOnClickListener{
            button.showAlignTop(balloon)
        }

        approve.setOnClickListener {
            val status = "Approve"
            val update = mapOf(
                "Status" to status
            )

            mDB.collection("Submission").document(uid)
                .update(update)
                .addOnCompleteListener {
                    Toast.makeText(activity, "record added successfully", Toast.LENGTH_SHORT).show()
                }
        }
        // Inflate the layout for this fragment
        return view
    }

    // Filename in Firebase
    var fileSub:String? = null

    private fun download(){
        storageReference = FirebaseStorage.getInstance().reference
        ref = storageReference.child("uploadedFile/primary:documents/Name.pptx")
        ref.downloadUrl.addOnSuccessListener { uri ->
            val url = uri.toString()
            Toast.makeText(activity, "Success",
                Toast.LENGTH_LONG).show()

                downloadFiles()

        }.addOnFailureListener { e ->
            // handle failure

        }
    }

    private fun downloadFiles(){
        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }

        ref.downloadUrl.addOnSuccessListener { uri ->
            val url = uri.toString()
            val request = DownloadManager.Request(Uri.parse(url))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            request.setTitle("Download")
            request.setDescription("Downloading File...")
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Name.pptx")
            val manager = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            manager.enqueue(request)
        }.addOnFailureListener { e ->
            // handle failure
        }
    }



}