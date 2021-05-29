package com.example.placessearch

import androidx.lifecycle.*
import com.example.placessearch.data.SearchResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val itemsFlow = MutableStateFlow<MutableSet<SearchResult>>(mutableSetOf())

    private val apiService by lazy {
        ApiService.create()
    }

    private fun loadItems(query: String) {
        viewModelScope.launch {
            apiService.getResults(
                input = query
            ).apply {
                itemsFlow.emit(prediction.toMutableSet())
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        loadItems(query)
    }
}