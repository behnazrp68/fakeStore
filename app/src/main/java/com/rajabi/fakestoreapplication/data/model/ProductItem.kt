package com.rajabi.fakestoreapplication.data.model


import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products_table")
data class ProductItem(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("key")
    val key:Int=0,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("is_bookmark")
    var isBookmark: Boolean

){
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}

class ProductArgType : JsonNavType<ProductItem>() {
    override fun fromJsonParse(value: String): ProductItem = Gson().fromJson(value, ProductItem::class.java)
    override fun ProductItem.getJsonParse(): String = Gson().toJson(this)

}