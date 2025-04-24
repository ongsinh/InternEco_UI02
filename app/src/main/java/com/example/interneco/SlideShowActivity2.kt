package com.example.interneco

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interneco.databinding.ActivitySlideShow2Binding

class SlideShowActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivitySlideShow2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlideShow2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setupUI()
//        handleItemClick()
    }

    private fun handleItemClick() {
        TODO("Not yet implemented")
    }

    private fun setupUI() {
        TODO("Not yet implemented")
    }
}