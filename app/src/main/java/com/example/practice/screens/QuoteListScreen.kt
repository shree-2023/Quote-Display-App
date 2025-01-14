package com.example.practice.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.model.Quote

@Composable
fun QuoteListScreen(data:Array<Quote>,onClick:(quote:Quote)->Unit){
    Column {
        Text(text ="Quote App",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.padding(8.dp,24.dp)
                .fillMaxWidth(1f))
        QuoteList(data =data, onClick )

    }
}