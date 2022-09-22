package com.ramanandroiddev.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ramanandroiddev.testapp.R
import com.ramanandroiddev.testapp.appComponent
import com.ramanandroiddev.testapp.databinding.ActivityMainBinding
import com.ramanandroiddev.testapp.di.factory.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

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