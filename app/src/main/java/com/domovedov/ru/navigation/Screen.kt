package com.domovedov.ru.navigation

sealed class Screen(val route: String){
    object StoriesFullScreen: Screen("storiesFullScreen")
    object ConfiguratorScreen: Screen("configuratorScreen")
    object HouseCard: Screen("houseCard")
    object ContactsBottomSheet: Screen("contactsBottomSheet")
    object SendRequestScreen: Screen("sendRequestScreen")
}
