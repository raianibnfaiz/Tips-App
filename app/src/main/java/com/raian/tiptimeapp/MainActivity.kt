package com.raian.tiptimeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raian.tiptimeapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            var amount = calculateTip()
            Log.d("MainActivity", amount.toString())
        }
    }
//    private fun calculateTip(){
//        val stringTextField = binding.costOfService.text.toString()
//        val cost = stringTextField.toDoubleOrNull()
//        if(cost == null){
//            binding.tipResult.text = ""
//            return
//        }
//        //binding.tipResult.text = cost.toString()
//        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
//            R.id.optionTwentyPercent -> 0.20
//            R.id.optionEighteenPercent -> 0.18
//            else -> 0.15
//        }
//        var tip = tipPercentage * cost
//        binding.tipResult.text = tip.toString()
//    }

//    @SuppressLint("StringFormatInvalid")
    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        Log.d("MainActivity", cost.toString())
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.optionTwentyPercent -> 0.20
            R.id.optionEighteenPercent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = formattedTip
    }


}