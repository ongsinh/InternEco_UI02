package com.example.interneco

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.MetricAffectingSpan
import android.text.style.TypefaceSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import androidx.core.widget.AutoSizeableTextView
import androidx.databinding.DataBindingUtil
import com.example.interneco.databinding.ActivityMainBinding
import com.example.interneco.databinding.ItemPurchaseBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupTextView()
        setupIncludeTextView()
        onClick()
    }


    private fun setupTextView() {
        val text1 = "Remove Ads for the\n"
        val text2 = "Best Experience"
        val spannable = SpannableString(text1 + text2)
        spannable.apply {
            // Text1: màu xám, font bold, size 22sp
            setSpan(ForegroundColorSpan(ContextCompat.getColor(this@MainActivity, R.color.text_color)), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(CustomTypefaceSpan(ResourcesCompat.getFont(this@MainActivity, R.font.nunito_sans_bold)!!), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(AbsoluteSizeSpan(resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._22sdp)), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            // Text2: màu đậm, font extra bold, size 30sp
            setSpan(ForegroundColorSpan(ContextCompat.getColor(this@MainActivity, R.color.text_color_primary)), text1.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(CustomTypefaceSpan(ResourcesCompat.getFont(this@MainActivity, R.font.nunito_sans_extra_bold)!!), text1.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(AbsoluteSizeSpan(resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._30sdp)), text1.length, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        binding.tv3.text = spannable
    }

    private fun setupIncludeTextView() {
        binding.includePurchase1.apply {
            tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
        binding.includePurchase2.apply {
            tvLifetime.text = "7-Day"
            tvOnetime.text = "Cancel anytime"
            tvBadge.visibility = View.GONE
            tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

    }

    private fun onClick() {
        binding.includePurchase1.item.setOnClickListener {
            binding.apply {
                includePurchase1.item.setBackgroundResource(R.drawable.bg_card_border)
                includePurchase2.item.setBackgroundResource(R.drawable.bg_card_border_before)
            }
        }

        binding.includePurchase2.item.setOnClickListener {
            binding.apply {
                includePurchase2.item.setBackgroundResource(R.drawable.bg_card_border)
                includePurchase1.item.setBackgroundResource(R.drawable.bg_card_border_before)
            }
        }
    }
}