package com.example.practice.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.practice.model.Quote


@Composable
fun QuoteList(data: Array<Quote>, onClick:(quote:Quote)-> Unit) {
    LazyColumn {
        items(data) { quote -> // Use `items` to iterate over the `data` array
            QuoteListItem(quote = quote,onClick)

        }
    }
}
