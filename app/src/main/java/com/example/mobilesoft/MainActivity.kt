package com.example.mobilesoft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Вывод результатов в лог или на экран
        val input = findViewById(R.id.text_input) as TextInputEditText
        val katet: TextView = findViewById(R.id.katet) as TextView
        val ploshyad: TextView = findViewById(R.id.ploshyad) as TextView
        val hypotenuze: TextView = findViewById(R.id.hypotenuze) as TextView

        val button = findViewById<Button>(R.id.button)

        fun removeLetters(word: String):Double {
            val re = Regex("[^0-9. ]")
            var new_word = word
            new_word = re.replace(new_word, "") // works
            return new_word.toDouble()
        }

        val default_katet = katet.text
        val default_ploshyad = ploshyad.text
        val default_hypotenuze = hypotenuze.text

        // Устанавливаем обработчик клика
        button.setOnClickListener {
            // Действие по нажатию кнопки
            katet.text = default_katet
            ploshyad.text = default_ploshyad
            hypotenuze.text = default_hypotenuze
            var parse = input.text.toString()
            if (parse.contains("L", ignoreCase = true)){
                val triangle = RightAngledTriangle(leg = removeLetters(parse))
                ploshyad.text = ploshyad.text.toString() + triangle.calculateArea().toString()
                katet.text = katet.text.toString() + triangle.calculateLeg().toString()
                hypotenuze.text = hypotenuze.text.toString() + triangle.calculateHypotenuse().toString()
            }
            else if (parse.contains("H", ignoreCase = true)){
                val triangle = RightAngledTriangle(hypotenuse = removeLetters(parse))
                ploshyad.text = ploshyad.text.toString() + triangle.calculateArea().toString()
                katet.text = katet.text.toString() + triangle.calculateLeg().toString()
                hypotenuze.text = hypotenuze.text.toString() + triangle.calculateHypotenuse().toString()
            }
            else if (parse.contains("A", ignoreCase = true)){
                val triangle = RightAngledTriangle(area = removeLetters(parse))
                ploshyad.text = ploshyad.text.toString() + triangle.calculateArea().toString()
                katet.text = katet.text.toString() + triangle.calculateLeg().toString()
                hypotenuze.text = hypotenuze.text.toString() + triangle.calculateHypotenuse().toString()
            }
        }
    }
}