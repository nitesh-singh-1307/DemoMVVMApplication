package com.instablog.demomvvmapplication.pagenations

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.instablog.demomvvmapplication.data.model.MerchantItems


class MerchentItemdataFactore : DataSource.Factory<Int, MerchantItems.Data.Item>() {

    private val itemLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, MerchantItems.Data.Item>> =
        MutableLiveData<PageKeyedDataSource<Int, MerchantItems.Data.Item>>()
    var merchentDataSource : MerchentDataSource ? = null

    override fun create(): DataSource<Int, MerchantItems.Data.Item> {
        merchentDataSource = MerchentDataSource()
        itemLiveDataSource.postValue(merchentDataSource)
        Log.e("datasourcefactor", "__________________________________" + merchentDataSource?.marchelist?.size)

        return  merchentDataSource!!
    }


    //getter for itemlivedatasource
    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, MerchantItems.Data.Item>> {
        return itemLiveDataSource
        Log.e("itemLiveDataSource", "__________________________________" + itemLiveDataSource?.value)
    }

}