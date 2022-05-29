package com.nisaefendioglu.movieapp.api

import com.nisaefendioglu.movieapp.model.MovieResponse
import com.nisaefendioglu.movieapp.helper.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovie(): Response<MovieResponse>

}