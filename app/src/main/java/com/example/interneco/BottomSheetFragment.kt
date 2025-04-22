package com.example.interneco

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.interneco.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        onClick()
        setupTextView()
        return binding.root
    }

    private fun setupTextView() {
        val fullText = getString(R.string.text_policy)

        val spannable = SpannableString(fullText)

        val termsStart = fullText.indexOf(getString(R.string.terms))
        val termsEnd = termsStart + R.string.terms.toString().length

        val privacyStart = fullText.indexOf(getString(R.string.privacy_policies))
        val privacyEnd = privacyStart + R.string.privacy_policies.toString().length

        val defaultTextColor = binding.tvPolicy.currentTextColor

        if (termsStart != -1) {
            spannable.setSpan(object : ClickableSpan() {
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
            spannable.setSpan(object : ClickableSpan() {
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

        binding.tvPolicy.text = spannable
        binding.tvPolicy.movementMethod = LinkMovementMethod.getInstance()


    }

    private fun onClick() {
        binding.imgDelete.setOnClickListener {
            dismiss()
        }
    }

}