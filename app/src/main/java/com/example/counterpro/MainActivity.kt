package com.example.counterpro

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0
    private fun updateCountText(tvCount: TextView){
                tvCount.text="Sayı: $count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnIncrease = findViewById<Button>(R.id.btnIncrease)
        val btnDecrease = findViewById<Button>(R.id.btnDecrease)
        val btnReset = findViewById<Button>(R.id.btnReset)
        btnIncrease.setOnClickListener {
            count++
            //tvCount.text = count.toString()
            updateCountText(tvCount)

        }
        btnDecrease.setOnClickListener {
            if (count>0){

                count--
                updateCountText(tvCount)

            }

        }
        btnReset.setOnClickListener {
            count =0
            //tvCount.text = count.toString()
            updateCountText(tvCount)

        }
    }
}
