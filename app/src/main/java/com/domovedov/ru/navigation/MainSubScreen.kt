package com.domovedov.ru.navigation

sealed class MainSubScreen(){
    object Home: Screen("storiesFullScreen")
    object N: Screen("houseCard")
}
