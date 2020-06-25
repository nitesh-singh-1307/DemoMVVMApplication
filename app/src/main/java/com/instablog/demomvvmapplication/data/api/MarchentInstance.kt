package com.instablog.demomvvmapplication.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BaseUrl = "https://easyshopnow.in/api/"
const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20
private val builder: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BaseUrl)
    .build()

object MarchentInstance {
    val retrofitService : Marchent_Api_Interface by lazy {
        builder.create(Marchent_Api_Interface::class.java)
    }
}