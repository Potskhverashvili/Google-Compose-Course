package com.example.practice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val amountOfRelations: Int,
)
