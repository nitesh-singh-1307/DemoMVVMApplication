package com.instablog.demomvvmapplication.pagenations

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.paging.PageKeyedDataSource
import com.instablog.demomvvmapplication.data.api.FIRST_PAGE
import com.instablog.demomvvmapplication.data.api.MarchentInstance
import com.instablog.demomvvmapplication.data.api.POST_PER_PAGE
import com.instablog.demomvvmapplication.data.model.MerchantItems
import retrofit2.Call
import retrofit2.Response

class MerchentDataSource : PageKeyedDataSource<Int, MerchantItems.Data.Item>() {
    private var page = FIRST_PAGE
    private var limit_page = POST_PER_PAGE

    var marchelist: ArrayList<MerchantItems.Data.Item> =
        ArrayList<MerchantItems.Data.Item>()


    val networkState: MutableLiveData<MerchantItems.Data.Item> = MutableLiveData()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MerchantItems.Data.Item>
    ) {
        MarchentInstance.retrofitService.getMarchent_values(
            "Y2aFT3JW23nRCPPbRiQt8KKRWqwDWWk7TBUA4vhpOIJ97BrJ9qEMJMcjmpdp",
            134,
            106,
            page,
            limit_page
        )
            .enqueue(object : retrofit2.Callback<MerchantItems.Data.Item> {
                override fun onFailure(call: Call<MerchantItems.Data.Item>, t: Throwable) {
                    Log.e("March_ViewModle_error", "" + t)
                }

                override fun onResponse(
                    call: Call<MerchantItems.Data.Item>,
                    response: Response<MerchantItems.Data.Item>
                ) {
                    if (response.body() != null) {
                        Log.e("loadInitialrespone==>", "response:::::" + response.body())
//                        val apiResponse = response.body()!!
//                        val responseItems = apiResponse.data
//                        networkState.postValue(apiResponse)
//                        marchelist.add(apiResponse)

                        marchelist.add(response.body()!!)

                        callback.onResult(marchelist, null, page + 1)

                        /* for (i in responseItems.items.indices) {
                             Log.e(
                                 "loadInitialrespone==>",
                                 "loop::::::" + responseItems.items[i]
                             )
                         }*/


                    }
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MerchantItems.Data.Item>) {
        MarchentInstance.retrofitService.getMarchent_values(
            "Y2aFT3JW23nRCPPbRiQt8KKRWqwDWWk7TBUA4vhpOIJ97BrJ9qEMJMcjmpdp",
            134,
            106,
            params.key,
            limit_page
        )
            .enqueue(object : retrofit2.Callback<MerchantItems.Data.Item> {
                override fun onFailure(call: Call<MerchantItems.Data.Item>, t: Throwable) {
                    Log.e("March_ViewModle_error", "" + t)
                }

                override fun onResponse(
                    call: Call<MerchantItems.Data.Item>,
                    response: Response<MerchantItems.Data.Item>
                ) {
                    if (response.body() != null) {
                        Log.e("Marchent_ViewModle", "" + response.body())
                        val apiResponse = response.body()!!
//                        val responseItems = apiResponse.data
                        marchelist.add(apiResponse)
                        if (20 >= params.key) {
                            callback.onResult(marchelist, params.key + 1)
                        }
                    }
                }
            })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MerchantItems.Data.Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}