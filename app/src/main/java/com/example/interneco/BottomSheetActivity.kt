package com.example.interneco

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interneco.databinding.ActivityBottomSheetBinding
import com.example.interneco.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomSheetBinding
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //assign behavior
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        //set status default
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

    }
}