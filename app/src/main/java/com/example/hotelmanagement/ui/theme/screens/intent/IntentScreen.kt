package com.example.hotelmanagement.ui.theme.screens.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.ui.theme.Pink
import com.example.hotelmanagement.ui.theme.newPink


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController){
    
  Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()
       ) {


      var selected by remember { mutableIntStateOf(0) }
      Scaffold(
          bottomBar = {
              NavigationBar(
                  containerColor = newPink,
              ) {
                  bottomNavItems.forEachIndexed { index, bottomNavItem ->
                      NavigationBarItem(
                          selected = index == selected,
                          onClick = {
                              selected = index
                              navController.navigate(bottomNavItem.route)
                          },
                          icon = {
                              BadgedBox(
                                  badge = {
                                      if (bottomNavItem.badges != 0) {
                                          Badge {
                                              Text(text = bottomNavItem.badges.toString())
                                          }
                                      } else if (bottomNavItem.hasNews) {
                                          Badge()
                                      }
                                  }
                              ) {
                                  Icon(imageVector =
                                  if (index == selected)
                                      bottomNavItem.selectedIcon
                                  else
                                      bottomNavItem.unselectedIcon,
                                      contentDescription = bottomNavItem.title)
                              }

                          },
                          label = {
                              Text(text = bottomNavItem.title)
                          })
                  }
              }

          },
          topBar = {
              TopAppBar(
                  title = { Text(text = "Pride Inn Hotel", color = Color.White) },
                  colors = TopAppBarDefaults.mediumTopAppBarColors(newPink)
              )

          },


          floatingActionButton = {
              FloatingActionButton(onClick = { /*TODO*/ }) {
                  IconButton(onClick = { /*TODO*/ }) {
                      Icon(imageVector = Icons.Default.Add,
                          contentDescription = "menu")
                  }
              }
          },
          //Content Section
          content = @Composable {
              Column(
                  modifier = androidx.compose.ui.Modifier
                      .fillMaxSize()
                      .padding(top = 70.dp)
                      .verticalScroll(rememberScrollState()),

                  ) {



                Row (modifier = Modifier.padding(start = 10.dp)){

                 Column {

                     Text(
                         text = "Pride Inn",
                         fontSize = 40.sp

                     )
                     Spacer(modifier = Modifier.width(40.dp))

                     Text(
                         text = "Management",
                         fontSize = 40.sp,
                         fontFamily = FontFamily.Monospace

                     )
                 }
                    Spacer(modifier = Modifier.width(40.dp))


                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "", modifier = Modifier.size(150.dp))
                    }



                }
                  Spacer(modifier = Modifier.height(40.dp))

                  //code for searchbar
                  var search by remember { mutableStateOf("")   }

                  OutlinedTextField(
                      value = search,
                      onValueChange = {search=it},
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(start = 20.dp, end = 20.dp),
                      leadingIcon = { androidx.compose.material3.Icon(imageVector = Icons.Default.Search, contentDescription = "")},
                      placeholder = { Text(text = "Search Hotel")}

                  )


                  Spacer(modifier = Modifier.height(20.dp))


                  Box (modifier = Modifier
                      .fillMaxWidth()
                      .padding(start = 10.dp, end = 10.dp)
                      .height(280.dp), contentAlignment = Alignment.Center)
                  {
                      Image(
                          painter = painterResource(id = R.drawable.img_6),
                          contentDescription = "home",
                          modifier = Modifier.fillMaxSize(),
                          contentScale = ContentScale.Crop
                      )
                  }


                  Spacer(modifier = Modifier.height(20.dp))


                  Box (modifier = Modifier
                      .fillMaxWidth()
                      .padding(start = 10.dp, end = 10.dp)
                      .height(280.dp), contentAlignment = Alignment.Center)
                  {
                      Image(
                          painter = painterResource(id = R.drawable.img),
                          contentDescription = "home",
                          modifier = Modifier.fillMaxSize(),
                          contentScale = ContentScale.Crop
                      )
                  }






              }
          }

                          )



          }

  }



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Details",
        route="details",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Pride Inn",
        route="Pride Inn",
        selectedIcon=Icons.Filled.PlayArrow,
        unselectedIcon=Icons.Outlined.PlayArrow,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)











@Composable
@Preview(showBackground = true)
fun IntentScreenPreview(){
    IntentScreen(rememberNavController())

}