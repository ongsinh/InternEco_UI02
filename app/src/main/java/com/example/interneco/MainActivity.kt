package com.example.interneco

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.interneco.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIncludeTextView()
        handleItemClick()
        onClick()
    }

    private fun onClick() {
        binding.btnContinue.setOnClickListener {
//            val bottomSheet = BottomSheetFragment()
//            bottomSheet.show(supportFragmentManager, "BottomSheet")

            val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()

        }
    }

    private fun setupIncludeTextView() {
        val includeBinding1 = binding.includePurchase1
        val includeBinding2 = binding.includePurchase2

        includeBinding1.apply {
            tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
        includeBinding2.apply {
            tvLifetime.text = getString(R.string._7_day)
            tvOnetime.text = getString(R.string.cancel_anytime)
            tvBadge.visibility = View.GONE
            tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

    }

    private fun handleItemClick() {
        binding.apply {
            item1.setOnClickListener {
                selectedItem(isCheck = true)
            }
            item2.setOnClickListener {
                selectedItem(isCheck = false)
            }
        }
    }

    private fun selectedItem(isCheck: Boolean) {
        binding.apply {
            item1.setBackgroundResource(if (isCheck) R.drawable.bg_card_border else R.drawable.bg_card_border_before)
            item2.setBackgroundResource(if (isCheck) R.drawable.bg_card_border_before else R.drawable.bg_card_border)
        }
    }


}