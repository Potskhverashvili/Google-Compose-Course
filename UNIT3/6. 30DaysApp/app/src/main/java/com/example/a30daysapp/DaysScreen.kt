package com.example.a30daysapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superherosapp.data.HeroesRepository
import com.example.superherosapp.model.Hero


@Composable
fun DayItem(day: String, image: Painter, description: String, modifier: Modifier = Modifier) {
    var expand by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = day,
                modifier = Modifier.padding(start = 12.dp)
            )
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .clickable {
                        expand = !expand
                    }
            ) {
                Image(
                    image, contentDescription = null,
                    modifier = Modifier,
                    contentScale = ContentScale.FillWidth
                )
            }

            if (expand) {
                Text(
                    text = description,
                    fontSize = 50.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

        }
    }
}


@Composable
fun DaysList(heroList: List<Hero>, modifier: Modifier = Modifier) {
    var days: Int = 1
    LazyColumn(modifier = modifier) {
        items(heroList) { item ->
            DayItem(
                day ="Days ${days++}",
                image = painterResource(item.imageRes),
                description = stringResource(item.descriptionRes)
            )

        }
    }
}


/*@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun DayItemPreview() {
    Surface() {
        DayItem(
            day = "Day 1",
            image = painterResource(R.drawable.android_superhero1),
            description = stringResource(R.string.description1)
        )
    }
}*/

@Preview
@Composable
fun DaysListPreview() {
    Surface() {
        DaysList(
            HeroesRepository.heroes,
            modifier = Modifier.padding(8.dp)
        )
    }
}