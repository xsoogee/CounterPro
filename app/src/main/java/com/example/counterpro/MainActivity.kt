package com.example.counterpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counterpro.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.core.content.edit



class MainActivity : AppCompatActivity() {

    private var count = 0
    private val prefsName = "counter_prefs"
    private val keyCount = "count"
    private lateinit var binding: ActivityMainBinding



    private fun updateCountText(){
                binding.tvCount.text=getString(R.string.count_text,count)
    }
    private fun saveCount() {
        val prefs = getSharedPreferences(prefsName, MODE_PRIVATE)
        prefs.edit {
            putInt(keyCount, count)
        }
    }
    private fun updateButtonState() {
        binding.btnDecrease.isEnabled = count > 0
        binding.btnReset.isEnabled= count > 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences(prefsName, MODE_PRIVATE)
        count = prefs.getInt(keyCount, 0)
        updateCountText()
        updateButtonState()


        binding.btnIncrease.setOnClickListener {
            count++
            //tvCount.text = count.toString()
            updateCountText()
            saveCount()
            updateButtonState()

        }
        binding.btnDecrease.setOnClickListener {
            if (count>0){

                count--
                updateCountText()
                saveCount()
                updateButtonState()
            }

        }
        binding.btnReset.setOnClickListener {
            count =0
            //tvCount.text = count.toString()
            updateCountText()
            saveCount()
            updateButtonState()
            Toast.makeText(this, getString(R.string.reset_message), Toast.LENGTH_SHORT).show()

        }
    }


}
