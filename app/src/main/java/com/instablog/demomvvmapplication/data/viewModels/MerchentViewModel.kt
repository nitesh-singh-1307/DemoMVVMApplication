package com.instablog.demomvvmapplication.data.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.instablog.demomvvmapplication.data.api.POST_PER_PAGE
import com.instablog.demomvvmapplication.data.model.MerchantItems
import com.instablog.demomvvmapplication.pagenations.MerchentItemdataFactore
import java.util.concurrent.Executor


class MerchentViewModel : ViewModel() {
    //creating livedata for PagedList  and PagedKeyedDataSource
    var itemPagedList: LiveData<PagedList<MerchantItems.Data.Item>>? = null
    var liveDataSource: MutableLiveData<PageKeyedDataSource<Int, MerchantItems.Data.Item>>? = null
   private  var merchentDataSourcefactor: MerchentItemdataFactore? = null


    init {
        merchentDataSourcefactor = MerchentItemdataFactore()
        liveDataSource = merchentDataSourcefactor!!.getItemLiveDataSource()
        //Getting PagedList config
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE).build()
        //Building the paged list
        itemPagedList = LivePagedListBuilder(merchentDataSourcefactor!!, pagedListConfig)
                .build()
        Log.e("itemPagedList", "__________________________________" + liveDataSource?.value)
        Log.e("itemPagedList", "__________________________________" + itemPagedList?.value)

    }


//    fun getMarchent_data() {Â
//        MarchentInstance.retrofitService.getMarchent_values(
//            "Y2aFT3JW23nRCPPbRiQt8KKRWqwDWWk7TBUA4vhpOIJ97BrJ9qEMJMcjmpdp",
//            134,
//            106,
//            1,
//            20
//        )
//            .enqueue(object : retrofit2.Callback<MerchantItems> {
//                override fun onFailure(call: Call<MerchantItems>, t: Throwable) {
//                    Log.e("March_ViewModle_error", "" + t)
//                }
//
//                override fun onResponse(
//                    call: Call<MerchantItems>,
//                    response: Response<MerchantItems>
//                ) {
//                    if (response.body() != null) {
//                        Log.e("Marchent_ViewModle", "" + response.body())
//                        merchant_livedata.postValue(response.body())
//                    }
//                }
//            })
//    }






}

