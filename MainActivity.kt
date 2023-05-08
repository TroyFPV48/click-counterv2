package com.example.clickcounterv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.clickcounterv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //create databinding object

        binding.textView.text = count.toString() //assign data binding object ass textView

        binding.incrementButton.setOnClickListener {
            val prevCount = count
            count++ //increase value
            binding.textView.text = count.toString()
            val message = "Increment: $prevCount -> $count"
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }

        binding.decrementButton.setOnClickListener {
            val prevCount = count
            count-- //decrease value
            binding.textView.text = count.toString() //update textView
            val message = "Decrement: $prevCount -> $count"
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }

        binding.resetButton.setOnClickListener {
            val prevCount = count
            count = 0 //reset
            binding.textView.text = count.toString()
            val message = "Reset: $prevCount -> $count"
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}