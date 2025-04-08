package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var position by remember { mutableIntStateOf(1) }

    val imageIds = when (position) {
        1 -> R.drawable.country_1
        2 -> R.drawable.country_2
        3 -> R.drawable.country_3
        4 -> R.drawable.country_4
        else -> R.drawable.country_1
    }

    val artworkTitle = when (position) {
        1 -> R.string.artwork_title_1
        2 -> R.string.artwork_title_2
        3 -> R.string.artwork_title_3
        4 -> R.string.artwork_title_4
        else -> R.string.artwork_title_1
    }

    val artist = when (position) {
        1 -> R.string.artist_1
        2 -> R.string.artist_2
        3 -> R.string.artist_3
        4 -> R.string.artist_4
        else -> R.string.artist_1
    }



    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ------------------------------ Image -----------------
        Surface(
            modifier = Modifier
                .width(400.dp)
                .height(500.dp)
                .padding(24.dp),
            shadowElevation = 20.dp
        ) {
            Image(
                painter = painterResource(imageIds),
                contentDescription = null,
                modifier = Modifier
                    .padding(32.dp)
                    .width(250.dp)
                    .height(300.dp)

            )
        }


        // ------------------------------ Texts ----------------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .background(color = Color(0xFFDCDCDC)),

            ) {
            Text(
                text = stringResource(artworkTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)
            )
            Text(
                text = stringResource(artist),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
        }


        // ---------------------- Buttons ----------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val buttonSize =
                Modifier
                    .padding(horizontal = 24.dp)
                    .size(width = 130.dp, height = 38.dp)

            Button(
                onClick = {
                    if (position == 1) {
                        position = 4
                    } else {
                        position--
                    }

                },
                modifier = buttonSize
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = {
                    if (position == 4) {
                        position = 1
                    } else {
                        position++
                    }
                },
                modifier = buttonSize
            ) {
                Text(text = "Next")
            }
        }

    }


}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}

