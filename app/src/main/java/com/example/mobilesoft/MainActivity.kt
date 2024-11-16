package com.example.mobilesoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var priceEditText: EditText
    private lateinit var discountSeekBar: SeekBar
    private lateinit var discountTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        priceEditText = findViewById(R.id.priceEditText)
        discountSeekBar = findViewById(R.id.discountSeekBar)
        discountTextView = findViewById(R.id.discountTextView)
        calculateButton = findViewById(R.id.calculateButton)

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
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("DISCOUNTED_PRICE", discountedPrice)
                }
                startActivity(intent)
            }
        }
    }
}