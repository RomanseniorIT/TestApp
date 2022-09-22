package com.ramanandroiddev.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ramanandroiddev.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.btnNextCat.setOnClickListener {
            viewModel.getCatImage()
        }
    }

    private fun initObservers() {
        viewModel.catLiveData().observe(this) { imageUrl ->
            Glide.with(binding.ivCat)
                .load(imageUrl)
                .placeholder(R.drawable.ic_cat_placeholder)
                .into(binding.ivCat)
        }
    }
}