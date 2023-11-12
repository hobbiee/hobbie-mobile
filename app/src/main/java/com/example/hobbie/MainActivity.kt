package com.example.hobbie

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hobbie.api.QuotesAPI
import com.example.hobbie.ui.RootNavigationGraph
import com.example.hobbie.ui.theme.HobbieTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var quotesAPI: QuotesAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//            var quote = quotesAPI.getTodayQuote()
//            Log.d("Quote", quote.body().toString())
//        }

//        suspend fun callApi() {
//            var quote = quotesAPI.getTodayQuote()
//            Log.d("Quote", quote.body().toString())
//        }

        setContent {
            HobbieTheme {

//                LoginScreen()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF1E8DA)
                ) {

                    RootNavigationGraph()

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