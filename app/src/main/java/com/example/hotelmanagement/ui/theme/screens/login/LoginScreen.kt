package com.example.hotelmanagement.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.data.AuthViewModel
import com.example.hotelmanagement.ui.theme.Pink
import com.example.hotelmanagement.navigation.ROUT_HOME
import com.example.hotelmanagement.navigation.ROUT_SIGNUP
import com.example.hotelmanagement.ui.theme.newPink

@Composable
fun LoginScreen(navController: NavController){

      Column (modifier = Modifier.fillMaxSize().background(newPink),
          horizontalAlignment = Alignment.CenterHorizontally

      ){
          Spacer(modifier = Modifier.height(40.dp))


         Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
             Image(
                 painter = painterResource(id = R.drawable.img_5),
                 contentDescription = "home",
                 modifier = Modifier
                     .size(200.dp),
                 contentScale = ContentScale.Crop
             )

          }


              Spacer(modifier = Modifier.height(10.dp))

              Text(
                  text = "PrideInn",
                  fontSize = 40.sp,
                  fontFamily = FontFamily.Cursive,
                  color = Color.White,
                  modifier = Modifier.fillMaxWidth(),
                  textAlign = TextAlign.Center

              )
              Spacer(modifier = Modifier.height(10.dp))
              Text(
                  text = "Already have an account.Please enter your credentials",
                  fontSize = 18.sp,
                  fontFamily = FontFamily.SansSerif,
                  color = Color.White,
                  modifier = Modifier.fillMaxWidth(),
                  textAlign = TextAlign.Center

              )

          Spacer(modifier = Modifier.height(40.dp))



          Column(){

              Card(
                  modifier = Modifier
                      .fillMaxWidth()
                      .height(700.dp),
                  shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                  colors = CardDefaults.cardColors(Color.White)
              ){


                  Spacer(modifier = Modifier.height(40.dp))


                  Text(
                      text = "Welcome Back!",
                      fontSize = 40.sp,
                      fontFamily = FontFamily.Cursive,
                      modifier = Modifier.fillMaxWidth(),
                      textAlign = TextAlign.Center

                  )
                  Spacer(modifier = Modifier.height(30.dp))


                  var email by remember { mutableStateOf("") }
                  var password by remember { mutableStateOf("") }

                  Spacer(modifier = Modifier.height(10.dp))

                  OutlinedTextField(
                      value =email ,
                      onValueChange ={ email=it},
                      label = { Text(text = "Email Address :")},
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(start = 20.dp, end = 20.dp),
                      leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="person" ) },
                      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                  )
                  Spacer(modifier = Modifier.height(10.dp))

                  OutlinedTextField(
                      value =password,
                      onValueChange ={ password=it},
                      label = { Text(text = "Password :")},
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(start = 20.dp, end = 20.dp),
                      leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription ="person" )},
                      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                      visualTransformation = PasswordVisualTransformation()

                  )
                  Spacer(modifier = Modifier.height(40.dp))


                  val context = LocalContext.current
                  val authViewModel = AuthViewModel.AuthViewModel(navController, context)
                  Button(
                      onClick = {
                          authViewModel.login(email,password)
                      },
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .padding(start = 20.dp, end = 20.dp),
                      colors = ButtonDefaults.buttonColors(Pink),
                      shape = RoundedCornerShape(10.dp)
                  ) {
                      Text(text = "Login")

                      Spacer(modifier = Modifier.height(10.dp))

                  }
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "Do not have an account ? Register",
                      fontSize = 18.sp,
                      fontFamily = FontFamily.SansSerif,
                      color = Color.Black,
                      modifier = Modifier
                          .fillMaxWidth()
                          .clickable {
                              navController.navigate(ROUT_SIGNUP)
                          },
                      textAlign = TextAlign.Center

                  )

                  Spacer(modifier = Modifier.height(20.dp))
                  Text(
                      text ="Login as Admin",
                      fontSize = 18.sp,
                      fontFamily = FontFamily.SansSerif,
                      color = newPink,
                      modifier = Modifier
                          .fillMaxWidth()
                          .clickable {
                              authViewModel.adminlogin(email, password)                           },
                      textAlign = TextAlign.Center

                  )

              }

          }






}


}
@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())

}