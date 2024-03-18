package com.bmi_express.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.a1_projeto.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextHeight = findViewById<TextInputEditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<TextInputEditText>(R.id.editTextWeight)
        val displayBMI = findViewById<TextView>(R.id.textViewBMIDisplay)

        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val heightStr: String = editTextHeight.text.toString()
            val weightStr: String = editTextWeight.text.toString()

            if (heightStr.isEmpty() && weightStr.isEmpty()) {
                Snackbar.make(
                    editTextWeight,
                    "Fill out ALL the fields",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else if (heightStr.isEmpty()) {
                Snackbar.make(
                    editTextHeight,
                    "Insert your height",
                    Snackbar.LENGTH_LONG

                ).show()
            } else if (weightStr.isEmpty()) {
                Snackbar.make(
                    editTextWeight,
                    "Insert your weight",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val height = heightStr.toFloat()
                val weight = weightStr.toFloat()

                val height2 = height * height
                val resultBMI = weight / height2

                println(resultBMI)
            }

        }


    }
}