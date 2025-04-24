package com.example.interneco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.interneco.databinding.ActivityPaywallFeatureBinding

class PayWallFeature : AppCompatActivity() {
    private lateinit var binding : ActivityPaywallFeatureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaywallFeatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun handleItemClick() {

    }

    private fun setupUI() {

    }
}