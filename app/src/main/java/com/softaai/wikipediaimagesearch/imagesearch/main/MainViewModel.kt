package com.softaai.wikipediaimagesearch.imagesearch.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softaai.wikipediaimagesearch.data.network.State
import com.softaai.wikipediaimagesearch.data.repository.ImageSearchRepository
import com.softaai.wikipediaimagesearch.model.Pages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val imageSearchRepository: ImageSearchRepository) :
    ViewModel() {

    private val _pagesLiveData = MutableLiveData<State<Pages>>()

    val pagesLiveData: LiveData<State<Pages>> = _pagesLiveData

    fun getPages() {
        viewModelScope.launch {
            imageSearchRepository.getPages()
                .onStart { _pagesLiveData.value = State.loading() }
                .map { resource -> State.fromResource(resource) }
                .collect { state -> _pagesLiveData.value = state }
        }
    }
}

