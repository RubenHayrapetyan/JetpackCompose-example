package com.domovedov.ru.navigation

sealed class Screen(val route: String){
    object StoriesFullScreen: Screen("storiesFullScreen")
    object ConfiguratorScreen: Screen("configuratorScreen")
    object HouseCardBottomSheet: Screen("houseCardBottomSheet")
    object ContactsBottomSheet: Screen("contactsBottomSheet")
}
