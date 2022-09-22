package com.ramanandroiddev.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramanandroiddev.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.btnNextCat.setOnClickListener {

        }
    }

    private fun initObservers() {

    }
}