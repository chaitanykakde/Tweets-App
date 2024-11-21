package com.syntax.tweetsy.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.syntax.tweetsy.R
import com.syntax.tweetsy.ui.theme.Black
import com.syntax.tweetsy.ui.theme.BlueGray


@Composable
fun LoginScreen(onClick:(category:String)->Unit){
    Surface() {

        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Column(modifier = Modifier.fillMaxSize()
                .padding(horizontal = 30.dp)) {
                LoginTextField(lable = "Name", trailing ="", modifier = Modifier.fillMaxWidth() )
                Spacer(modifier = Modifier.height(15.dp))
                 Spacer(modifier = Modifier.height(20.dp))
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .height(40.dp),
                    onClick = {onClick("category")},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Get Started", style = MaterialTheme.typography.labelMedium)

                }



            }


        }
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(contentAlignment = Alignment.TopCenter)
    {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    id = R.string.app_logo
                ),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.find_house),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )

    }
}