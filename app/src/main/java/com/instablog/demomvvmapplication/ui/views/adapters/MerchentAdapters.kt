package com.instablog.demomvvmapplication.ui.views.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.instablog.demomvvmapplication.R
import com.instablog.demomvvmapplication.data.model.MerchantItems
import kotlinx.android.synthetic.main.merchent_item_adapter.view.*

class MerchentAdapters(
    val context: Context,
    private var itemlist: ArrayList<MerchantItems>?
) : PagedListAdapter<MerchantItems, MerchentAdapters.MerchentItemViewHolder>(
    MarchentDiffCallback()
) {

    class MarchentDiffCallback : DiffUtil.ItemCallback<MerchantItems>() {
        override fun areItemsTheSame(oldItem: MerchantItems, newItem: MerchantItems): Boolean {
            return oldItem.data.shop.id == newItem.data.shop.id
        }

        override fun areContentsTheSame(oldItem: MerchantItems, newItem: MerchantItems): Boolean {
            return oldItem == newItem
        }

    }


    class MerchentItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_baaner_image: AppCompatImageView = itemView.img_item
        val txt_title: AppCompatTextView = itemView.txt_title
        val txt_secound_price: AppCompatTextView = itemView.txt_secound_price
        val txt_price: AppCompatTextView = itemView.txt_price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchentItemViewHolder {
        val lay_view = LayoutInflater.from(parent.context)
            .inflate(R.layout.merchent_item_adapter, parent, false)
        return MerchentItemViewHolder(lay_view)

    }

    override fun onBindViewHolder(holder: MerchentItemViewHolder, position: Int) {
//        holder.txt_title.text = itemlist!!.get(position).title
//        holder.txt_secound_price.text = itemlist!!.get(position).offerPrice
//        holder.txt_price.text = itemlist!!.get(position).salePrice
        Log.e("check_image_link", itemlist!!.get(position).data.items.get(0).offerPrice)
//        Glide.with(mActivity).load(itemlist!!.get(position).imageLink).into(holder.img_baaner_image)


    }

    override fun getItemCount(): Int {
        return itemlist!!.size
    }


}