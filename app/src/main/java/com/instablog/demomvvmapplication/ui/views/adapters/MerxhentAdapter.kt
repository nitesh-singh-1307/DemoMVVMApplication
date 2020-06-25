package com.instablog.demomvvmapplication.ui.views.adapters

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.module.GlideModule
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.instablog.demomvvmapplication.R
import com.instablog.demomvvmapplication.data.model.MerchantItems
import kotlinx.android.synthetic.main.merchent_item_adapter.view.*

class MerxhentAdapter(
    private var mActivity: Activity,
    private var itemlist: ArrayList<MerchantItems.Data.Item>?

) : RecyclerView.Adapter<MerxhentAdapter.MerchenViewholder>() {
    class MerchenViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_baaner_image: AppCompatImageView = itemView.img_item
        val txt_title: AppCompatTextView = itemView.txt_title
        val txt_secound_price: AppCompatTextView = itemView.txt_secound_price
        val txt_price: AppCompatTextView = itemView.txt_price
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchenViewholder {
        val lay_view = LayoutInflater.from(parent.context)
            .inflate(R.layout.merchent_item_adapter, parent, false)
        return MerchenViewholder(lay_view)
    }

    override fun getItemCount(): Int {
        return itemlist!!.size
    }

    override fun onBindViewHolder(holder: MerchenViewholder, position: Int) {
        holder.txt_title.text = itemlist!!.get(position).title
        holder.txt_secound_price.text = itemlist!!.get(position).offerPrice
        holder.txt_price.text = itemlist!!.get(position).salePrice
        Log.e("check_image_link", itemlist!!.get(position).imageLink)
        Glide.with(mActivity).load(itemlist!!.get(position).imageLink).into(holder.img_baaner_image)

    }

}