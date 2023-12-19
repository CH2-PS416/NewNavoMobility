package com.bangkit.navomobility.ui.screen.onboarding

import androidx.annotation.DrawableRes
import com.bangkit.navomobility.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Explore Uncharted",
        description = "Welcome to Navo Mobility! Discover unforgettable adventures with our transportation recommendations.",
        image = R.drawable.prolog
    ),
    Page(
        title = "Journey Beyond",
        description = "Experience boundless journeys with NavoMobility. We help you find the best transportation options for the tourist destination or city of your choice.",
        image = R.drawable.prolog1
    ),
    Page(
        title = "Wander Freely",
        description = "Explore the world with ease. NavoMobility not only provides transportation recommendations but also ensures each of your journeys is memorable. Let's get started!",
        image = R.drawable.prolog2
    )
)
