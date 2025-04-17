package com.example.interneco

import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan

class CustomTypefaceSpan(private val newType: Typeface) : MetricAffectingSpan() {
    override fun updateDrawState(tp: TextPaint) {
        tp.typeface = newType
    }

    override fun updateMeasureState(tp: TextPaint) {
        tp.typeface = newType
    }

}