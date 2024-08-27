package com.example.hotelmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.ui.theme.screens.splash.SplashScreen
import com.example.hotelmanagement.ui.theme.screens.home.HomeScreen
import com.example.hotelmanagement.ui.theme.screens.login.LoginScreen
import com.example.hotelmanagement.ui.theme.screens.signup.SignupScreen
import com.example.hotelmanangement.ui.theme.screens.about.AboutScreen
import com.example.hotelmanagement.navigation.ROUT_ABOUT
import com.example.hotelmanagement.navigation.ROUT_HOME
import com.example.hotelmanagement.navigation.ROUT_LOGIN
import com.example.hotelmanagement.navigation.ROUT_SIGNUP
import com.example.hotelmanagement.navigation.ROUT_SPLASH
import com.example.hotelmanagement.ui.theme.screens.drinks.DrinkScreen
import com.example.hotelmanagement.ui.theme.screens.entertainment.EntertainmentScreen
import com.example.hotelmanagement.ui.theme.screens.food.FoodScreen
import com.example.hotelmanagement.ui.theme.screens.hotels.HotelScreen
import com.example.hotelmanagement.ui.theme.screens.intent.IntentScreen
import com.example.hotelmanagement.ui.theme.screens.menu.MenuScreen
import com.example.hotelmanagement.ui.theme.screens.rooms.RoomScreen
import com.example.propertyplus.ui.theme.screens.dashboard.DashboardScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }


        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)

        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController = navController)

        }
        composable(ROUT_INTENT) {
            IntentScreen(navController = navController)

        }

        composable(ROUT_MENU) {
            MenuScreen(navController = navController)

        }

        composable(ROUT_ROOM) {
            RoomScreen(navController = navController)

        }

        composable(ROUT_FOOD) {
         FoodScreen(navController = navController)

        }

        composable(ROUT_DRINK) {
        DrinkScreen(navController = navController)

        }

        composable(ROUT_ENTERTAINMENT) {
            EntertainmentScreen(navController = navController)
        }

        composable(ROUT_HOTEL) {
           HotelScreen(navController = navController)

        }





    }
}












