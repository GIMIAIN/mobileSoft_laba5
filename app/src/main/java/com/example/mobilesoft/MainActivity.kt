package com.example.mobilesoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var priceEditText: EditText
    private lateinit var currencySpinner: Spinner
    private lateinit var discountSeekBar: SeekBar
    private lateinit var discountTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        priceEditText = findViewById(R.id.priceEditText)
        currencySpinner = findViewById(R.id.currencySpinner)
        discountSeekBar = findViewById(R.id.discountSeekBar)
        discountTextView = findViewById(R.id.discountTextView)
        calculateButton = findViewById(R.id.calculateButton)

        // Инициализация Spinner с валютами
        val currencies = listOf(
            Currency("USD", 75.0),
            Currency("EUR", 85.0),
            Currency("RUB", 1.0),
            Currency("JPY", 0.55)
        )
        val currencyNames = currencies.map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        currencySpinner.adapter = adapter

        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                discountTextView.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        calculateButton.setOnClickListener {
            val price = priceEditText.text.toString().toDoubleOrNull()
            val discount = discountSeekBar.progress

            if (price != null) {
                val discountedPrice = price * (1 - discount / 100.0)
                val selectedCurrency = currencySpinner.selectedItem.toString()

                // Получение курса выбранной валюты
                val currencyRate = currencies.find { it.name == selectedCurrency }?.rateToRuble ?: 1.0
                val priceInSelectedCurrency = discountedPrice / currencyRate
                val priceInRUB = discountedPrice // Цена уже в рублях

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("PRICE_IN_SELECTED_CURRENCY", priceInSelectedCurrency)
                    putExtra("PRICE_IN_RUB", priceInRUB)
                    putExtra("SELECTED_CURRENCY", selectedCurrency)
                }
                startActivity(intent)
            }
        }
    }
}