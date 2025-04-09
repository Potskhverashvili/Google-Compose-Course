package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.data.DataSource
import com.example.practice.model.Topic
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 8.dp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }

}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            // ------------------------- Image ----------------------------
            Box {
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = stringResource(topic.name),
                    modifier = modifier
                        .size(height = 68.dp, width = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            // ------------------------ Texts and Logo -----------------------
            Column {
                // -------------- Name -----------------
                Text(
                    text = stringResource(topic.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    maxLines = 1
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // ----------- Logo ------------
                    Icon(
                        painter = painterResource(R.drawable.ic_relation),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    // ---------- Available  Course ----------------
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicsAppPreview() {
    PracticeTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}
