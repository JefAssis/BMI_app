package com.example.a1_projeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))


        val btnCalculator: Button = findViewById(R.id.calculator)
        val edtWeightBMI: EditText = findViewById(R.id.weight_for_BMI)
        val edtHeightBMI: EditText = findViewById(R.id.height_for_BMI)



        btnCalculator.setOnClickListener{
            /*
            //obtained the user's message
            val message: String = edtWeight_BMI.text.toString()
            //gives a new message via TextView
            txtResult.text = message*/

            val heightStr = edtHeightBMI.text.toString()
            val weightStr = edtWeightBMI.text.toString()
            if (heightStr .isNotEmpty() && weightStr .isNotEmpty()){

            val height : Float = heightStr .toFloat()
            val finalHeight: Float = height * height

            val weight: Float = weightStr.toFloat()
            val result: Float = weight / finalHeight


            val intent = Intent(this,ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)
            }else{
                Toast.makeText(this, "Fill up all the the boxes", Toast.LENGTH_LONG).show()
            }
        }
    }
}