package com.raian.tiptimeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var calculateButton: Button
    private lateinit var costOfService: EditText
    private lateinit var nameTextView: TextView
    private lateinit var costTextView: TextView
    private lateinit var check: Switch
    private lateinit var costServiceOption : CheckBox
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameTextView = findViewById(R.id.textView3)
        costTextView = findViewById(R.id.textView5)
        calculateButton = findViewById(R.id.calculate_button)
        costOfService= findViewById((R.id.cost_of_service))
        check = findViewById(R.id.round_up_switch)

        calculateButton.setOnClickListener {
            val name =  costOfService.text.toString()
            nameTextView.text = check.isChecked.toString()
            costTextView.text = "$name"
            costOfService.setText("")
        }
    }
}