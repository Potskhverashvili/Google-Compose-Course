package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.ui.theme._30DaysAppTheme
import com.example.superherosapp.data.HeroesRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    _30DaysApp()
                }
            }
        }
    }
}

@Composable
fun _30DaysApp() {
    DaysList(
        HeroesRepository.heroes,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun _30DaysAppPreview(){
    _30DaysAppTheme {
        Surface() {
            DaysList(
                HeroesRepository.heroes,
                modifier = Modifier.padding(8.dp)
            )
        }


    }
}