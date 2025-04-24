package com.example.interneco

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.interneco.databinding.ActivityPaywallBinding

class PayWallActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPaywallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaywallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        handleItemClick()
        setupTextView()
    }


    private fun handleItemClick() {
        val items = listOf(
            binding.item1 to binding.includedSlideShow1.rbCheck,
            binding.item2 to binding.includedSlideShow2.rbCheck,
            binding.item3 to binding.includedSlideShow3.rbCheck
        )

        items.forEachIndexed{ index , (layout, icon) ->
            layout.setOnClickListener {
                items.forEachIndexed { i, (l, iv) ->
                    l.setBackgroundResource(if (i == index) R.drawable.background_gradient else R.drawable.bg_card_slideshow)
                    iv.setImageResource(if (i == index) R.drawable.check else R.drawable.radiobutton_unchecked)
                }
            }
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, PayWallFeature::class.java)
            startActivity(intent)
        }
    }

    private fun setupUI() {
        binding.apply {
            includedSlideShow2.apply {
                tvPrice.text = getString(R.string.slideshow_price2)
                tvMonth.text = getString(R.string.slideshow_month2)
                rbCheck.setImageResource(R.drawable.radiobutton_unchecked)
                tvFreeDay.text = getString(R.string.monthly)

            }

            includedSlideShow3.apply {
                tvPrice.text = getString(R.string.slideshow_price3)
                tvMonth.text = getString(R.string.slideshow_month3)
                rbCheck.setImageResource(R.drawable.radiobutton_unchecked)
                tvFreeDay.text = getString(R.string.life_time)
                tvCancel.text = getString(R.string.one_time_payment)
            }

            item2.apply {
                setBackgroundResource(R.drawable.bg_card_slideshow)
            }
            item3.apply {
                setBackgroundResource(R.drawable.bg_card_slideshow)
            }
        }
    }

    private fun setupTextView() {
        val fullText1 = getString(R.string.text_policy)
        val fullText2 = getString(R.string.or_use_limited)

        val term = getString(R.string.terms)
        val privacy = getString(R.string.privacy_policies)

        val spannable1 = SpannableString(fullText1)
        val spannable2 = SpannableString(fullText2)


        val termsStart = fullText1.indexOf(term)
        val termsEnd = termsStart + term.length

        val privacyStart = fullText1.indexOf(privacy)
        val privacyEnd = privacyStart + privacy.length

        val defaultTextColor = binding.tvPolicy.currentTextColor

        if (termsStart != -1) {
            spannable1.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    Toast.makeText(widget.context, "Clicked Terms", Toast.LENGTH_SHORT).show()
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = true
                    ds.color = defaultTextColor
                }
            }, termsStart, termsEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        if (privacyStart != -1) {
            spannable1.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    Toast.makeText(widget.context, "Clicked Privacy", Toast.LENGTH_SHORT).show()
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = true
                    ds.color = defaultTextColor
                }
            }, privacyStart, privacyEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        spannable2.setSpan(object : ClickableSpan(){
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = ContextCompat.getColor(binding.tvLimited.context, R.color.text_color_task2)
            }

            override fun onClick(p0: View) {
                TODO("Not yet implemented")
            }
        }, 0, fullText2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvPolicy.text = spannable1
        binding.tvLimited.text = spannable2
        binding.tvPolicy.movementMethod = LinkMovementMethod.getInstance()
    }




}