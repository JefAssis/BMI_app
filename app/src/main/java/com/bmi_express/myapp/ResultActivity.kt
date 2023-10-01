package com.bmi_express.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.a1_projeto.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tv_result_BMI = findViewById<TextView>(R.id.tv_result_BMI)
        val tv_classification_BMI = findViewById<TextView>(R.id.tv_classification_BMI)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tv_result_BMI.text = result.toString()


        val classification =
        if (result < 18.5f){
             "Underweight"
        }else if(result in 18.5f..24.9f) {
             "Healthy Weight"
        }else if (result in 25f..29.9f) {
             "Overweight"
        }else if (result in 30.0f..39.9f){
             "Obese"
        }else{
             "Dangerously Obese!"
        }

        tv_classification_BMI.text = getString(R.string.message_classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
            return super .onOptionsItemSelected(item)

        }
    }
