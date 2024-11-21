package com.syntax.tweetsy.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.syntax.tweetsy.R
import com.syntax.tweetsy.viewmodels.CategoryViewModel


@Composable
fun CategoryScreen(onClick:(category:String)->Unit){

    val categoryViewModel:CategoryViewModel= hiltViewModel()

    val categories: State<List<String>> =categoryViewModel.categories.collectAsState()
    val categoryImages = mapOf(
        "Revolution" to R.drawable.revoution, // Add actual image resources in drawable
        "Earth" to R.drawable.earth,
        "Mystery" to R.drawable.mystery, // Add actual image resources in drawable
        "Motivation" to R.drawable.moti,
        "Facts" to R.drawable.facts, // Add actual image resources in drawable
        "Inspiration" to R.drawable.inspiration,
        "Technology" to R.drawable.technology, // Add actual image resources in drawable
        "Adventure" to R.drawable.adventure,
        "Health" to R.drawable.health, // Add actual image resources in drawable
        "Success" to R.drawable.success,

        // Add more categories and their corresponding images
    )
    if(categories.value.isEmpty()){
         Box (modifier = Modifier.fillMaxSize(1f),
             contentAlignment = Alignment.Center){
             CircularLoadingIndicator()

         }
    }else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp,10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(categories.value.distinct()) { categoryImages[it]?.let { it1 ->
                CategoryItem(category = it,
                    onClick,
                    it1
                )
            } }

        }
    }
}

@Composable
fun CategoryItem(category:String,onClick:(category:String)->Unit,img:Int){
    Box (modifier = Modifier.padding(4.dp)
        .size(160.dp)
        .clip(RoundedCornerShape(8.dp))
        .paint(painter = painterResource(id = img),
            contentScale = ContentScale.Crop)
        .border(1.dp, Color(0xFFEEEEEE))
        .clickable { onClick(category) }
    , contentAlignment = Alignment.BottomCenter){

        Text(text = category,
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.bodyLarge)

    }
}
@Composable
fun CircularLoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize(), // Takes up the full screen space
        contentAlignment = Alignment.Center // Centers the loading indicator
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp), // Set the size of the indicator
            color = MaterialTheme.colorScheme.primary, // Set the color
            strokeWidth = 4.dp // Optional: Adjust the thickness of the circle
        )
    }
}