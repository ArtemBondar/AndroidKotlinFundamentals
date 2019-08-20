package com.github.artembondar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUp: Button = findViewById(R.id.count_up_button)
        val reset: Button = findViewById(R.id.reset_button)

        rollButton.setOnClickListener { rollDice() }
        countUp.setOnClickListener { countUp() }
        reset.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val random = Random().nextInt(6) + 1
        resultText.text = random.toString()
    }

    private fun countUp() {
        val result: String = resultText.text.toString()
        val countUpText: String
        countUpText = if (result.equals(resources.getString(R.string.hello_world_text), ignoreCase = true)) {
            "1"
        } else if (!result.equals("6", ignoreCase = true)) {
            (resultText.text.toString().toInt() + 1).toString()
        } else {
            resultText.text.toString()
        }
        resultText.text = countUpText
    }

    private fun reset() {
        val result: String = resultText.text.toString()
        if (!result.equals(resources.getString(R.string.hello_world_text), ignoreCase = true)) {
            resultText.text = "0"
        }
    }
}
