package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.model.Topic
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color(0xFFC5C5C5))
    ) {
        Image(
            painter = painterResource(topic.imageResourceId),
            contentDescription = stringResource(topic.stringResourceId),
            Modifier.size(height = 68.dp, width = 68.dp)
        )

        Column(
            modifier = Modifier.padding(top = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(topic.stringResourceId),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp),
            )

            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_relation),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )

                Text(
                    text = topic.amountOfRelations.toString(),
                    fontWeight = FontWeight.Medium
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicsAppPreview() {
    PracticeTheme {
        TopicCard(
            Topic(
                stringResourceId = R.string.photography,
                imageResourceId = R.drawable.photography,
                amountOfRelations = 58,
            )
        )
    }
}