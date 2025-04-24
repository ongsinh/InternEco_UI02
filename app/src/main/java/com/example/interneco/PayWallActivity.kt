package com.example.interneco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.interneco.databinding.ActivityPaywallBinding

class PayWallActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPaywallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaywallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        handleItemClick()
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
                includedSlideShow2.tvPrice.text = getString(R.string.slideshow_price2)
                includedSlideShow2.tvMonth.text = getString(R.string.slideshow_month2)
                includedSlideShow2
            }

            includedSlideShow3.tvPrice.text = getString(R.string.slideshow_price3)
            includedSlideShow3.tvMonth.text = getString(R.string.slideshow_month3)
        }
    }




}