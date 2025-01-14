package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.DataManager.currentPage
import com.example.practice.screens.QuoteDetails
import com.example.practice.screens.QuoteListScreen
import com.example.practice.ui.theme.PracticeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {

App()


        }
    }
}

@Composable
fun App() {
    val currentPage = DataManager.currentPage.value

    BackHandler(enabled = currentPage == PAGES.DETAIL) {
        DataManager.currentPage.value = PAGES.LISTING
    }
    if (DataManager.isDataLoaded.value) {


        when (DataManager.currentPage.value) {
            PAGES.LISTING -> {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)
                }
            }
            PAGES.DETAIL -> {
                DataManager.currentQuote?.let { quote ->
                    QuoteDetails(quote = quote)
                }
            }
        }
    } else {
        // You can show a loading indicator or placeholder if data is not yet loaded
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Loading...")
        }
    }
}

enum class PAGES{
    LISTING,
    DETAIL
}