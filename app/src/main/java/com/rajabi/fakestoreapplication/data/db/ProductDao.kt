package com.rajabi.fakestoreapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rajabi.fakestoreapplication.data.model.ProductItem


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(product: ProductItem)


    @Query("DELETE FROM products_table")
    suspend fun deleteAllProducts()

    @Query("SELECT * FROM products_table Where id = :id")
    suspend fun getProducts(id: Int): ProductItem


    @Query("UPDATE products_table set `isBookmark`= :isbookmark Where id = :id ")
    suspend fun updateBookmark(id: Int, isbookmark: Boolean)
}