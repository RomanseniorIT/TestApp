package com.ramanandroiddev.testapp.ui

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
    private val imageLoadingListener = object : RequestListener<Drawable> {

        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            onError()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            binding.btnNextCat.isEnabled = true
            return false
        }
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
            binding.btnNextCat.isEnabled = false
            viewModel.getCatImage()
        }
    }

    private fun initObservers() {
        viewModel.catLiveData().observe(this) { imageUrl ->
            Glide.with(binding.ivCat)
                .load(imageUrl)
                .listener(imageLoadingListener)
                .placeholder(R.drawable.ic_cat_placeholder)
                .into(binding.ivCat)
        }

        viewModel.errorLiveData().observe(this, ::onError)
    }

    private fun onError(@StringRes errorText: Int = R.string.unknown_error) {
        Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show()
        binding.btnNextCat.isEnabled = true
    }
}