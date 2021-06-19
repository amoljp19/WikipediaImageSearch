package com.softaai.wikipediaimagesearch.imagesearch.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softaai.wikipediaimagesearch.R
import com.softaai.wikipediaimagesearch.data.network.State
import com.softaai.wikipediaimagesearch.databinding.ActivityMainBinding
import com.softaai.wikipediaimagesearch.imagesearch.adapter.WikiSearchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mViewModel: MainViewModel by viewModels()
    
    lateinit var mViewBinding: ActivityMainBinding

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: WikiSearchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
        getPages()

        recyclerView = findViewById<RecyclerView>(R.id.rvGridView)
        adapter = WikiSearchListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

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
                is State.Loading -> Toast.makeText(
                    applicationContext,
                    "Loading...",
                    Toast.LENGTH_SHORT
                ).show()
                is State.Success -> {
                    //adapter.submitList(state.data)
                    Toast.makeText(applicationContext, " " + state.data, Toast.LENGTH_SHORT).show()
                }
                is State.Error -> {
                    Toast.makeText(applicationContext, " " + state.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}