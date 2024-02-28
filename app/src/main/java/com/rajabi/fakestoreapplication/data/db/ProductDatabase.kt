package com.rajabi.fakestoreapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rajabi.fakestoreapplication.data.model.ProductItem

@Database(
    entities = [
        ProductItem::class],
    version = 1, exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}