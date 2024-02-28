//package com.rajabi.bookapplication.data.db
////
//
//import android.R.attr.value
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import com.rajabi.bookapplication.data.model.APIResponse
//import com.rajabi.bookapplication.data.model.Author
//import com.rajabi.bookapplication.data.model.Book
//import com.rajabi.bookapplication.data.model.BookList
//
//
//class Converter {
//
//    private val gson = Gson()
//
//    @TypeConverter
//    fun fromAuthorList(authorEntityList: List<Author>): String {
//        return gson.toJson(authorEntityList)
//    }
//
//    @TypeConverter
//    fun toAuthorList(authorListString: String): List<Author> {
//        val listType = object : TypeToken<List<Author>>() {}.type
//        return gson.fromJson<List<Author>>(authorListString, listType)
//    }
//
//
//    @TypeConverter
//    fun fromBookList(bookEntityList: List<Book>): String {
//        return gson.toJson(bookEntityList)
//    }
//
//    @TypeConverter
//    fun toBookList(bookListString: String): List<Book> {
//        val listType = object : TypeToken<List<Book>>() {}.type
//        return gson.fromJson<List<Book>>(bookListString, listType)
//    }
//
//    companion object {
//        fun fromBook(page: String, hasMore: Boolean, books: BookList): APIResponse {
//            return APIResponse(books, hasMore, page)
//        }
//
//        fun fromBooksToBookList(books:List<Book>):BookList{
//            return BookList(books)
//        }
//    }
//
//}