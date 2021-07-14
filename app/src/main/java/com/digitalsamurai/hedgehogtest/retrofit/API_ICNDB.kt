package com.digitalsamurai.hedgehogtest.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface API_ICNDB  {
    @GET("random/{count}")
    fun getRandomJokes(@Path("count") count : Int) : Call<DataJokes>

    companion object Factory{
        fun create() : API_ICNDB{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.icndb.com/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(API_ICNDB::class.java)
        }
    }
}