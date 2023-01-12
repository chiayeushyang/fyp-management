package com.example.pairassginment.supervisor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pairassginment.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import com.skydoves.balloon.overlay.BalloonOverlayAnimation
import com.skydoves.balloon.showAlignTop


class GiveMarkAndApprove : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_give_mark_and_approve, container, false)
        val button = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        val balloon = createBalloon(requireContext()) {
            setArrowSize(10)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(BalloonSizeSpec.WRAP)
            setArrowPosition(0.5f)
            setCornerRadius(4f)
            setArrowAlignAnchorPadding(10)
            setAlpha(0.9f)
            setPadding(10)
            setIsVisibleOverlay(true)
            setOverlayColorResource(R.color.balloon_overlay)
            setOverlayPadding(6f)
            setOverlayPaddingColorResource(R.color.colorPrimary)
            setBalloonOverlayAnimation(BalloonOverlayAnimation.FADE)
            setDismissWhenOverlayClicked(false)
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
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GiveMarkAndApprove.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GiveMarkAndApprove().apply {

            }
    }
}