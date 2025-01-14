package com.example.practice

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.practice.model.Quote
import com.google.gson.Gson

object DataManager {

var data= emptyArray<Quote>()
    var currentQuote:Quote?=null
    var currentPage= mutableStateOf(PAGES.LISTING)
    var isDataLoaded= mutableStateOf(false)
    fun loadAssetsFromFile(context: Context){
     val inputStream=context.assets.open("quote.json")
        val size=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8)
        val gson= Gson()
        data=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true
    }
    fun switchPages(quote: Quote? = null) {
        if (currentPage.value == PAGES.LISTING) {
            currentQuote = quote
            currentPage.value = PAGES.DETAIL
        } else {
            currentPage.value = PAGES.LISTING
        }
    }

}