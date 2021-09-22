package com.domovedov.ru.navigation

sealed class Screen(val route: String){
    object StoriesFullScreen: Screen("storiesFullScreen")
    object HouseCard: Screen("houseCard")
}
