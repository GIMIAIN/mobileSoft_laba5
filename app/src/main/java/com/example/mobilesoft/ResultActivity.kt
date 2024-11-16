package com.example.mobilesoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var resultInRUBTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTextView = findViewById(R.id.resultTextView)
        resultInRUBTextView = findViewById(R.id.resultInRUBTextView)

        val priceInSelectedCurrency = intent.getDoubleExtra("PRICE_IN_SELECTED_CURRENCY", 0.0)
        val priceInRUB = intent.getDoubleExtra("PRICE_IN_RUB", 0.0)
        val selectedCurrency = intent.getStringExtra("SELECTED_CURRENCY") ?: "USD"

        resultTextView.text = "Цена в $selectedCurrency = %.2f".format(priceInSelectedCurrency)
        resultInRUBTextView.text = "Цена в RUB = %.2f".format(priceInRUB)
    }
}