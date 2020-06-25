package com.instablog.demomvvmapplication.data.api

import com.instablog.demomvvmapplication.data.model.MerchantItems
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface Marchent_Api_Interface {

    @FormUrlEncoded
    @POST("merchant_items")
    fun getMarchent_values(
        @Header("Authorization") Authorization: String,
        @Field("user_id") user_id: Int,
        @Field("shop_id") shop_id: Int,
        @Field("page") page: Int,
        @Field("limit") limit: Int
    ): Call<MerchantItems.Data.Item>
}