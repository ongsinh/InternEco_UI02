package com.example.interneco

import android.graphics.Paint
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.interneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIncludeTextView()
        setupTextView()
        handleItemClick()
    }


    private fun setupTextView() {
        val text1 = getString(R.string.remove_ads_for)
        val text2 = getString(R.string.best_experiences)
        val spannable = SpannableString(text1 + text2)
        spannable.apply {
            // Text1: màu xám, font bold, size 22sp
            setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.text_color
                    )
                ), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                CustomTypefaceSpan(
                    ResourcesCompat.getFont(
                        this@MainActivity,
                        R.font.nunito_sans_bold
                    )!!
                ), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                AbsoluteSizeSpan(resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._22sdp)),
                0,
                text1.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            // Text2: màu đậm, font extra bold, size 30sp
            setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.text_color_primary
                    )
                ), text1.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                CustomTypefaceSpan(
                    ResourcesCompat.getFont(
                        this@MainActivity,
                        R.font.nunito_sans_extra_bold
                    )!!
                ), text1.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                AbsoluteSizeSpan(resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._30sdp)),
                text1.length,
                spannable.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        binding.tv3.text = spannable
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