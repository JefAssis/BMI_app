package com.example.a1_projeto

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.a1_projeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        setSupportActionBar(findViewById(R.id.toolbar))
        val btnCalculator: Button = findViewById(R.id.calculator)
        val edtWeightBMI: EditText = findViewById(R.id.weight_for_BMI)
        val edtHeightBMI: EditText = findViewById(R.id.height_for_BMI)
        val switchGender: SwitchCompat = findViewById(R.id.switch_gender)

        val sharedPreferences = getSharedPreferences ("Mode", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val nightMode = sharedPreferences.getBoolean("night", false)

        if (nightMode){
            switchGender.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }


        

        //switcher - DarkMode
             //Man
        switchGender.setOnCheckedChangeListener { buttomView, isChecked ->
            if(!isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("night", false)
                editor.apply()
             //Woman
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("night", true)
                editor.apply()
            }

        }



        btnCalculator . setOnClickListener {
            val heightStr = edtHeightBMI.text.toString()
            val weightStr = edtWeightBMI.text.toString()
            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {

                val height: Float = heightStr.toFloat()
                val finalHeight: Float = height * height

                val weight: Float = weightStr.toFloat()
                val result: Float = weight / finalHeight


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill up all the the boxes", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        return true
    }

    fun OnDefaultToggleClick(view: View) {
        Toast.makeText(
            this, "DefaultToggle", Toast.LENGTH_SHORT
        ).show()
    }

}