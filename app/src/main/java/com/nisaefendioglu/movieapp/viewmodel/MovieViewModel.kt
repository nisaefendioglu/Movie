package com.nisaefendioglu.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nisaefendioglu.movieapp.model.MovieItem
import com.nisaefendioglu.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    private val _response = MutableLiveData<List<MovieItem>>()
    val responseMovie: LiveData<List<MovieItem>>
        get() = _response

    init {
        getAllMovie()
    }

    private fun getAllMovie() = viewModelScope.launch {
        repository.getMovie().let {response ->

            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("tag", "getAllMovie Error: ${response.code()}")
            }
        }
    }

}