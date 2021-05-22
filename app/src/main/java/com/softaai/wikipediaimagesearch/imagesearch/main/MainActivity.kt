package com.softaai.wikipediaimagesearch.imagesearch.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.softaai.wikipediaimagesearch.R
import com.softaai.wikipediaimagesearch.data.network.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.pagesLiveData.value?.let { currentState ->
            if (!currentState.isSuccessful()) {
                getPages()
            }
        }
        observePages()
    }

    private fun getPages() = mViewModel.getPages()

    private fun observePages() {
        mViewModel.pagesLiveData.observe(this) { state ->
            when (state) {
                is State.Loading -> Toast.makeText(applicationContext, "Loading...", Toast.LENGTH_SHORT).show()
                is State.Success -> {
                    if (!state.data.equals(null)) {
                        Toast.makeText(applicationContext, " " + state.data, Toast.LENGTH_SHORT).show()
                    }
                }
                is State.Error -> {
                    Toast.makeText(applicationContext, " " + state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}