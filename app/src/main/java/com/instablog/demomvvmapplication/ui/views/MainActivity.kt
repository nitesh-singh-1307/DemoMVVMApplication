package com.instablog.demomvvmapplication.ui.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.instablog.demomvvmapplication.R
import com.instablog.demomvvmapplication.data.model.MerchantItems
import com.instablog.demomvvmapplication.data.viewModels.MerchentViewModel
import com.instablog.demomvvmapplication.ui.views.adapters.MerxhentAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MerchentViewModel
    private var recy_view: RecyclerView? = null
    private var  MerchentAdapter : MerxhentAdapter ? = null
    private  var  marchelist : ArrayList<MerchantItems.Data.Item>  = ArrayList<MerchantItems.Data.Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recy_view = findViewById(R.id.recyclerView)
        viewModel = ViewModelProviders.of(this).get(MerchentViewModel::class.java)
//        viewModel = ViewModelProvider(this).get(MerchentViewModel::class.java)

        viewModel.itemPagedList?.observe(this , Observer<PagedList<MerchantItems.Data.Item>> {
            Log.e("Paged List",Gson().toJson(it))
            Log.e("Check_page_list", "" + it)

        })

     /*   viewModel!!.itemPagedList!!.observe(this, Observer { march_item ->
            Log.e("Check_page_list", "" + march_item)

        })*/

      /*  viewModel!!.fetchmerchentitemdata?.observe(this, Observer { march_item ->
            for (i in march_item.data.items.indices){
                marchelist.add(march_item.data.items.get(i))
            }
            MerchentAdapter = MerxhentAdapter(this@MainActivity ,marchelist)
            Log.e("Marchent_item_mainActivity", "" + marchelist)
            val linear_layopumaneger = LinearLayoutManager(this)
            recy_view!!.layoutManager = linear_layopumaneger
            recy_view?.adapter = MerchentAdapter
        })*/
    }
}
