package com.domovedov.ru.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.domovedov.ru.common.ContactsBottomSheet
import com.domovedov.ru.ui.configurator.ConfiguratorScreen
import com.domovedov.ru.ui.favorites.FavoritesScreen
import com.domovedov.ru.ui.home.HomeScreen
import com.domovedov.ru.ui.home.housecard.HouseCard
import com.domovedov.ru.ui.home.stories.StoriesFullScreenView
import com.domovedov.ru.ui.more.MoreScreen
import com.domovedov.ru.ui.myproject.MyProjectScreen
import com.domovedov.ru.ui.region.RegionScreen
import com.domovedov.ru.ui.requests.SendRequestScreen
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalMaterialNavigationApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {
        addHomeScreen(navController)
        addRegionScreen()
        addMyProjectScreen(navController)
        addFavoritesScreen()
        addMoreScreen()
        addHouseCard(navController)
        addConfiguratorScreen(navController)
        addStoriesFullScreen(navController)
        addContactsBottomSheet()
        addSendRequestScreen(navController)
    }
}

private fun NavGraphBuilder.addSendRequestScreen( navController: NavController){
    composable(Screen.SendRequestScreen.route){
        SendRequestScreen(navController = navController)
    }
}

@ExperimentalMaterialNavigationApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.addContactsBottomSheet(){
    bottomSheet(Screen.ContactsBottomSheet.route){
        ContactsBottomSheet()
    }
}

@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@ExperimentalMaterialNavigationApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.addHouseCard( navController: NavController){
    composable(Screen.HouseCard.route){
        HouseCard( navController)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addRegionScreen() {
    composable(NavigationItem.Region.route) {
        RegionScreen()
    }
}
@ExperimentalPagerApi
private fun NavGraphBuilder.addMyProjectScreen(navController: NavController) {
    composable(NavigationItem.MyProject.route) {
        MyProjectScreen(navController)
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addFavoritesScreen() {
    composable(NavigationItem.Favorites.route) {
        FavoritesScreen()
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addHomeScreen(navController: NavController) {
    composable(NavigationItem.Home.route) {
        HomeScreen(navController = navController)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addMoreScreen() {
    composable(NavigationItem.More.route) {
        MoreScreen()
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addStoriesFullScreen(navController: NavController) {
    composable(Screen.StoriesFullScreen.route) {
        StoriesFullScreenView(navController)
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addConfiguratorScreen(navController: NavController) {
    composable(Screen.ConfiguratorScreen.route) {
        ConfiguratorScreen(navController)
    }
}


//private fun NavGraphBuilder.addDogGraph(navController: NavController) {
//    navigation(route = Screen.Dog, startDestination = Screen.Dog.Adopt) {
//        composable(route = Screen.Dog.Adopt) { backStackEntry ->
//            val dogId = backStackEntry.arguments?.getString("dogId")
//            requireNotNull(dogId) { "dogId parameter wasn't found. Please make sure it's set!" }
//            AdoptionScreen(
//                dogId,
//                navigateUp = { navController.popBackStack(DogScreen.Adopt, inclusive = true) }
//            )
//        }
//        composable(route = Screen.Dog.ContactDetails) { backStackEntry ->
//            val dogId = backStackEntry.arguments?.getString("dogId")
//            requireNotNull(dogId) { "dogId parameter wasn't found. Please make sure it's set!" }
//            AdoptionContactDetailsScreen(dogId)
//        }
//    }
//}