package com.syntax.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.syntax.tweetsy.R
import com.syntax.tweetsy.models.TweetListItem
import com.syntax.tweetsy.viewmodels.DetailViewModel

@Composable
fun DetailScreen(){
    val detailViewModel:DetailViewModel= hiltViewModel()
    val tweets: State<List<TweetListItem>> =detailViewModel.tweets.collectAsState()

    if(tweets.value.isEmpty()){

        Box (modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center){
            CircularLoadingIndicator()

        }
    }
    else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.img),
                    contentScale = ContentScale.Crop
                ) // Set background image
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                // Make sure the content isn't hidden behind system bars
            ) {
                items(tweets.value) { tweet ->
                    TweetListItems(tweet = tweet.text)
                }
            }
        }
    }
}

@Composable
fun TweetListItems(tweet:String){

        Card(elevation = CardDefaults.cardElevation(5.dp),modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            ,
            border = BorderStroke(1.dp, Color(0xFFA58EC9)),
            content = {
                Text(
                    text = tweet,
                    modifier = Modifier.padding(20.dp)
                        , style =MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.SemiBold)

                )
            }
        )
    }

