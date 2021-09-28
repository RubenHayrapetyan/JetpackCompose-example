package com.domovedov.ru.navigation

import com.domovedov.ru.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object Home : NavigationItem("home", R.drawable.ic_navigation_home, "Дома")
    object Region : NavigationItem("region", R.drawable.ic_navigation_region, "Участки")
    object MyProject : NavigationItem("myProject", R.drawable.ic_navigation_my_project, "Мой проект")
    object Favorites : NavigationItem("favorites", R.drawable.ic_navigation_favorites, "Избранное")
    object More : NavigationItem("more", R.drawable.ic_navigation_more, "Еще")
}
