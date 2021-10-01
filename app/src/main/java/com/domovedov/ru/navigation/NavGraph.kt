package com.domovedov.ru.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.domovedov.ru.ui.favorites.FavoritesScreen
import com.domovedov.ru.ui.home.HomeScreen
import com.domovedov.ru.ui.home.housecard.HouseCard
import com.domovedov.ru.ui.home.stories.StoriesFullScreenView
import com.domovedov.ru.ui.more.MoreScreen
import com.domovedov.ru.ui.myproject.MyProjectScreen
import com.domovedov.ru.ui.region.RegionScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        addHomeScreen(navController)
        addRegionScreen()
        addMyProjectScreen()
        addFavoritesScreen()
        addMoreScreen()
     //   addHouseCardScreen()
        addStoriesFullScreen(navController)

    }
}

@ExperimentalPagerApi
private fun NavGraphBuilder.addRegionScreen() {
    composable(NavigationItem.Region.route) {
        RegionScreen()
    }
}
@ExperimentalPagerApi
private fun NavGraphBuilder.addMyProjectScreen() {
    composable(NavigationItem.MyProject.route) {
        MyProjectScreen()
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addFavoritesScreen() {
    composable(NavigationItem.Favorites.route) {
        FavoritesScreen()
    }
}

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

//@ExperimentalMaterialApi
//@ExperimentalPagerApi
//private fun NavGraphBuilder.addHouseCardScreen() {
//    composable(Screen.HouseCard.route) {
//        HouseCard()
//    }
//}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
private fun NavGraphBuilder.addStoriesFullScreen(navController: NavController) {
    composable(Screen.StoriesFullScreen.route) {
        StoriesFullScreenView(navController)
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