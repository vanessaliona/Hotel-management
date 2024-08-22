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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.ui.theme.Pink


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
                  containerColor = Color.Red,
                  contentColor = Color.Blue
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
                  title = { Text(text = "Pride Inn Hotel") },
                  colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Blue)
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
                      .padding(top = 70.dp, start = 20.dp),

                  ) {


                  Row {
                      Card(
                          modifier = androidx.compose.ui.Modifier
                              .height(180.dp)
                              .width(200.dp)
                      ) {
                          Box(
                              modifier = androidx.compose.ui.Modifier
                                  .height(500.dp)
                                  .fillMaxWidth(),
                              contentAlignment = Alignment.Center
                          ) {

                              Image(
                                  painter = painterResource(id = R.drawable.img_7),
                                  contentDescription = "home",
                                  modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                                  contentScale = ContentScale.Crop
                              )
                              Icon(
                                  imageVector = Icons.Default.Favorite,
                                  contentDescription = "favourite",
                                  modifier = androidx.compose.ui.Modifier
                                      .align(Alignment.TopStart).padding(10.dp)


                              )
                          }
                      }
                      Column(modifier = androidx.compose.ui.Modifier.padding(start = 2.dp)) {

                          Text(text = "PrideInn Westlands Luxury Boutique Hotel")
                          Text(text = "The best you can find")
                          Row {
                              Icon(imageVector = Icons.Default.Star, contentDescription = "")
                              Icon(imageVector = Icons.Default.Star, contentDescription = "")
                              Icon(imageVector = Icons.Default.Star, contentDescription = "")
                              Icon(imageVector = Icons.Default.Star, contentDescription = "")
                              Icon(imageVector = Icons.Default.Star, contentDescription = "")
                          }
                          Text(text = "1.5K ")
                          val mContext = LocalContext.current

                          Button(
                              onClick = {
                                  val callIntent=Intent(Intent.ACTION_DIAL)
                                  callIntent.data="tel:0746348846".toUri()
                                  mContext.startActivity(callIntent)
                              },
                              colors = ButtonDefaults.buttonColors(Color.Blue),
                              shape = RoundedCornerShape(10.dp)
                          ) {
                              Text(text = "Call")
                          }
                      }

                  }
                  //End of card
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

                  val mContext = LocalContext.current

                  Button(
                      onClick = {
                          val simToolKitLaunchIntent =
                              mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                          simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                      },
                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Color.Blue),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "MPESA")
                  }
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))



                  Button(
                      onClick = {
                          val shareIntent = Intent(Intent.ACTION_SEND)
                          shareIntent.type = "text/plain"
                          shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("vanessaliona966@gmail.com"))
                          shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                          shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                          mContext.startActivity(shareIntent)
                      },
                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Color.Cyan),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "CALL")
                  }
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

                  Button(
                      onClick = {
                          val smsIntent=Intent(Intent.ACTION_SENDTO)
                          smsIntent.data="smsto:0746348846".toUri()
                          smsIntent.putExtra("sms_body","Hello Visitors,how was your day?")
                          mContext.startActivity(smsIntent)
                      },
                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Color.Red),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "SMS")
                  }
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

                  Button(
                      onClick = {
                          val shareIntent = Intent(Intent.ACTION_SEND)
                          shareIntent.type = "text/plain"
                          shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("www.prideinn.co.ke"))
                          shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                          shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                          mContext.startActivity(shareIntent)
                      },
                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Color.Magenta),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "EMAIL")
                  }
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

                  Button(
                      onClick = {
                          val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                          if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                              mContext.startActivity(cameraIntent)
                          }else{
                              println("Camera app is not available")
                          }

                      },
                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Color.Cyan),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "CAMERA")
                  }
                  Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

                  Button(
                      onClick = {
                          val shareIntent=Intent(Intent.ACTION_SEND)
                          shareIntent.type="text/plain"
                          shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                          mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
                      },

                      modifier = androidx.compose.ui.Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Pink),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "SHARE")
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