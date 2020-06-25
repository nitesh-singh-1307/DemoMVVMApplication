package com.instablog.demomvvmapplication.data.model
import com.google.gson.annotations.SerializedName


data class MerchantItems(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("responseCode")
    val responseCode: Int
) {
    data class Data(
        @SerializedName("about_us")
        val aboutUs: AboutUs,
        @SerializedName("items")
        val items: List<Item>,
        @SerializedName("shop")
        val shop: Shop,
        @SerializedName("shop_image")
        val shopImage: String,
        @SerializedName("total_items")
        val totalItems: Int
    ) {
        data class AboutUs(
            @SerializedName("about")
            val about: String
        )

        data class Item(
            @SerializedName("active")
            val active: Boolean,
            @SerializedName("condition")
            val condition: String,
            @SerializedName("feedbacks")
            val feedbacks: List<Any>,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_link")
            val imageLink: String,
            @SerializedName("offer_price")
            val offerPrice: String,
            @SerializedName("product_id")
            val productId: Int,
            @SerializedName("sale_price")
            val salePrice: String,
            @SerializedName("shop_id")
            val shopId: Int,
            @SerializedName("slug")
            val slug: String,
            @SerializedName("stock_quantity")
            val stockQuantity: Int,
            @SerializedName("title")
            val title: String
        )

        data class Shop(
            @SerializedName("id")
            val id: Int,
            @SerializedName("legal_name")
            val legalName: String,
            @SerializedName("logo")
            val logo: Logo,
            @SerializedName("name")
            val name: String
        ) {
            data class Logo(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("extension")
                val extension: String,
                @SerializedName("extra_images")
                val extraImages: Any,
                @SerializedName("featured")
                val featured: Int,
                @SerializedName("id")
                val id: Int,
                @SerializedName("imageable_id")
                val imageableId: Int,
                @SerializedName("imageable_type")
                val imageableType: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("order")
                val order: Int,
                @SerializedName("path")
                val path: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("updated_at")
                val updatedAt: String
            )
        }
    }
}