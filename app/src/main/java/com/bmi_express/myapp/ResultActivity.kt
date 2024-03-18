package com.bmi_express.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.a1_projeto.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResultBmi = findViewById<TextView>(R.id.tv_result_BMI)
        val tvClassificationBmi = findViewById<TextView>(R.id.tv_classification_BMI)

        //Assuming you have the result value available
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        //Creating an instance of CaulculateFragment

        //Calling the calculateClassification function with the result parameter

        tvResultBmi.text = result.toString()

    }
}