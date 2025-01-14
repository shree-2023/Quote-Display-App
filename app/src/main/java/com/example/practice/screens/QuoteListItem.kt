package com.example.practice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.model.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick:(quote:Quote)->Unit){
    Card(elevation = CardDefaults.elevatedCardElevation(5.dp),
        modifier = Modifier
            .clickable{onClick(quote)}
            .padding(20.dp)
       ) {
Row ( ) {
    Image(
       imageVector = Icons.Filled.FormatQuote,
        colorFilter = ColorFilter.tint(Color.White) ,
        contentDescription = "", modifier = Modifier.size(40.dp).rotate(180F)
            .background(Color.Black)
       )
    Spacer(modifier = Modifier.width(10.dp))
   Column(modifier = Modifier.weight(2f) ) {
        Text(
            text =quote.text,
            style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(4.dp)
        )
       Box(modifier = Modifier.background(Color.Gray).height(1.dp).fillMaxWidth(.4f))
       Text(
           text =quote.author,
           style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Thin),
           modifier = Modifier.padding(4.dp)

       )
    }
}
    }

}
