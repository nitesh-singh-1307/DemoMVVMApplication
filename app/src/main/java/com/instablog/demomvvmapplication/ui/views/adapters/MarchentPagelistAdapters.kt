package com.instablog.demomvvmapplication.ui.views.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.instablog.demomvvmapplication.data.api.MarchentInstance
import com.instablog.demomvvmapplication.data.model.MerchantItems

class MarchentPagelistAdapters(public val context: Context) :
    PagedListAdapter<MerchantItems, RecyclerView.ViewHolder>(MarchentDiffCallbacks()) {


    companion object{
        class MarchentDiffCallbacks : DiffUtil.ItemCallback<MerchantItems>() {
            override fun areItemsTheSame(oldItem: MerchantItems, newItem: MerchantItems): Boolean {
                return oldItem.data.shop.id == newItem.data.shop.id
            }

            override fun areContentsTheSame(oldItem: MerchantItems, newItem: MerchantItems): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}