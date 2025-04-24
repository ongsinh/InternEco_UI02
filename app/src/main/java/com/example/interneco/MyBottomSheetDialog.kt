package com.example.interneco

import android.content.Context
import android.view.LayoutInflater
import com.example.interneco.databinding.ActivityBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MyBottomSheetDialog(
    context: Context
) : BottomSheetDialog(context) {
    private val binding by lazy {
        ActivityBottomSheetBinding.inflate(LayoutInflater.from(context))
    }

    init {
        setContentView(binding.root)
        setupUI()
        expandBottomSheet()
    }

    private fun expandBottomSheet() {
        binding.root.post {
            expandFully()
        }
    }

    private fun expandFully() {

    }

    private fun setupUI() {
        binding.apply {
            includedGift2.tvPrice.text = context.getString(R.string.text_price2)
            imgDelete.setOnClickListener {
                dismiss()
            }
        }
    }


}