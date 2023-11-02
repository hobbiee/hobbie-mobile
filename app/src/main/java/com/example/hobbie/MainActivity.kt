package com.example.hobbie

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hobbie.api.QuotesAPI
import com.example.hobbie.ui.Navigation
import com.example.hobbie.ui.theme.HobbieTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var quotesAPI: QuotesAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//            var quote = quotesAPI.getTodayQuote()
//            Log.d("Quote", quote.body().toString())
//        }

        suspend fun callApi() {
            var quote = quotesAPI.getTodayQuote()
            Log.d("Quote", quote.body().toString())
        }

        setContent {
            HobbieTheme {

//                LoginScreen()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Navigation()

//                    Button(onClick = {
//                        GlobalScope.launch {
//                            callApi()
//                        }
//                    }) {
//
//                    }
//                    Map()
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HobbieTheme {
        Greeting("Android")
    }
}