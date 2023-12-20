package com.bangkit.navomobility.ui.screen

import com.bangkit.navomobility.R

sealed class BottomBarScreen(
    val route :String,
    val title :String,
    val icon :Int,
    val icon_focused : Int
)
{
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home,
        icon_focused = R.drawable.ic_home_focused
    )

    object Jalan : BottomBarScreen(
        route = "jalan",
        title = "Jalan",
        icon = R.drawable.ic_track,
        icon_focused = R.drawable.ic_track_focused
    )

    object History : BottomBarScreen(
        route = "history",
        title = "History",
        icon = R.drawable.ic_history,
        icon_focused = R.drawable.ic_history_focused
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        icon_focused = R.drawable.ic_profile_focused
    )
}
