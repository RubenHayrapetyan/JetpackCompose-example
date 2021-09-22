package com.domovedov.ru.navigation

import com.domovedov.ru.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object Home : NavigationItem("home", R.drawable.ic_navigation_home_icon, "Дома")
    object Region : NavigationItem("region", R.drawable.ic_navigation_region_icon, "Участки")
    object MyProject : NavigationItem("myProject", R.drawable.ic_navigation_my_project_icon, "Мой проект")
    object Favorites : NavigationItem("favorites", R.drawable.ic_navigation_favorites_icon, "Избранное")
    object More : NavigationItem("more", R.drawable.navigation_more_icon, "Еще")
}
