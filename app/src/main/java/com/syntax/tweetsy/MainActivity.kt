package com.syntax.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.syntax.tweetsy.api.TweetsyAPI
import com.syntax.tweetsy.screens.CategoryScreen
import com.syntax.tweetsy.screens.DetailScreen
import com.syntax.tweetsy.screens.LoginScreen
import com.syntax.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Vector
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

      @OptIn(ExperimentalMaterial3Api::class)
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)


          enableEdgeToEdge()
          setContent {

              TweetsyTheme {

                  Column(modifier = Modifier.wrapContentHeight().systemBarsPadding()) {

                      TopScreen()

                      Box() {
                          App()

                      }
                  }
              }

          }

      }

    @Composable
    private fun TopScreen() {
        Row(
            modifier = Modifier

                .fillMaxWidth()
                .height(60.dp), // Ensure the row takes up the full width
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Title text
            Text(
                text = "Tweetsy",
                fontSize = 25.sp,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
            Icon(
                imageVector = Icons.Filled.Favorite, // Use imageVector for Material Icons
                contentDescription = "Favorite Icon",
                tint = Color(0xFF6A75B1), // Set tint color for the icon
                modifier = Modifier.size(30.dp) // Optional size
            )

            // Add a Spacer to push icons to the end of the row
            Spacer(modifier = Modifier.weight(1f))

            // Search icon
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Search Icon",
                tint = Color(0xFF6A75B1),
                modifier = Modifier
                    .size(35.dp)
                // Optional padding for better spacing
            )

            // Home icon

        }
    }
}

@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "login" ) {
        composable(route="login"){
            LoginScreen{
                navController.navigate("category/${it}")
            }
        }
        composable(route = "category/{login}", arguments = listOf(
            navArgument("login"){
                type=NavType.StringType
            }
        )){

            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type=NavType.StringType
                }
            )
        ){
            DetailScreen()

        }
    }
}


