package com.example.mobilesoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTextView = findViewById(R.id.resultTextView)

        val discountedPrice = intent.getDoubleExtra("DISCOUNTED_PRICE", 0.0)

        resultTextView.text = "Цена = %.2f".format(discountedPrice)
    }
}