package com.example.hotelmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.ui.theme.screens.account.AddAccountScreen
import com.example.hotelmanagement.ui.theme.screens.account.ViewAccountScreen
import com.example.hotelmanagement.ui.theme.screens.admin.AdminScreen
import com.example.hotelmanagement.ui.theme.screens.dashboard.DashboardScreen
import com.example.hotelmanagement.ui.theme.screens.splash.SplashScreen
import com.example.hotelmanagement.ui.theme.screens.home.HomeScreen
import com.example.hotelmanagement.ui.theme.screens.login.LoginScreen
import com.example.hotelmanagement.ui.theme.screens.signup.SignupScreen
import com.example.hotelmanangement.ui.theme.screens.about.AboutScreen
import com.example.hotelmanagement.ui.theme.screens.drinks.DrinkScreen
import com.example.hotelmanagement.ui.theme.screens.entertainment.EntertainmentScreen
import com.example.hotelmanagement.ui.theme.screens.hotels.HotelScreen
import com.example.hotelmanagement.ui.theme.screens.intent.IntentScreen
import com.example.hotelmanagement.ui.theme.screens.map.MapScreen
import com.example.hotelmanagement.ui.theme.screens.menus.AddMenuScreen
import com.example.hotelmanagement.ui.theme.screens.menus.ViewMenuScreen
import com.example.hotelmanagement.ui.theme.screens.room.AddRoomScreen
import com.example.hotelmanagement.ui.theme.screens.room.ViewRoomScreen
import com.example.hotelmanagement.ui.theme.screens.rooms.RoomScreen

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

        composable(ROUT_ADMIN) {
            AdminScreen(navController = navController)

        }

        composable(ROUT_ROOM) {
            RoomScreen(navController = navController)

        }

        composable(ROUT_MAP) {
         MapScreen(navController = navController)

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

        composable(ADD_MENU_URL) {
            AddMenuScreen(navController = navController)
        }

        composable(VIEW_MENU_URL) {
            ViewMenuScreen(navController = navController)

        }

        composable(ADD_ROOM_URL) {
            AddRoomScreen(navController=navController)
        }

        composable(VIEW_ROOM_URL) {
            ViewRoomScreen(navController = navController)

        }
        composable(ADD_ACCOUNT){
            AddAccountScreen(navController = navController)
        }
        composable(VIEW_ACCOUNT){
            ViewAccountScreen(navController = navController)
        }







    }
}












