package com.digitalsamurai.hedgehogtest.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Array

data class DataJokes(

    @Expose
    @SerializedName("type")
    val type : String,

    @Expose
    @SerializedName("value")
    val value: ArrayList<Joke> = ArrayList()

)
data class Joke(
    @Expose
    @SerializedName("id")
    val id : Int,

    @Expose
    @SerializedName("joke")
    val joke : String,

    @Expose
    @SerializedName("categories")
    val categories : ArrayList<String> = ArrayList()
)