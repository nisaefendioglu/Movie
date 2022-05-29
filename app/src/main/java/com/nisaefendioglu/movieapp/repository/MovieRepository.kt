package com.nisaefendioglu.movieapp.repository

import com.nisaefendioglu.movieapp.api.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovie() = apiService.getMovie()
}