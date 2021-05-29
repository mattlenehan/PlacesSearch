package com.example.placessearch

import com.example.placessearch.data.AutocompleteResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("autocomplete/json")
    suspend fun getResults(
        @Query("key") key: String = "AIzaSyC3s4DuNYs_SccOm3ZvXlozsMeQzuiMbHo",
        @Query("input") input: String
    ): AutocompleteResponse

    companion object{
        fun create() : ApiService{
            val baseUrl = "https://maps.googleapis.com/maps/api/place/"
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}