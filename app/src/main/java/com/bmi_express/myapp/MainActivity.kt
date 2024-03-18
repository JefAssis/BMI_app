package com.bmi_express.myapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a1_projeto.R
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextHeight = findViewById<TextInputEditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<TextInputEditText>(R.id.editTextWeight)

        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener{
            val weight = editTextWeight.text
            val height = editTextHeight.text



        }


    }
}