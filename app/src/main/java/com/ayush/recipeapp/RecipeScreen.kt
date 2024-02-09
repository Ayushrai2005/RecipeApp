package com.ayush.recipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipeScreen(modifier : Modifier = Modifier){
    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error != null ->{
                Text(text = "Error Occurred")
            }

            else->{
                //Display Categories
            }
        }

    }

}


@Composable
fun CategoryScreen(categories: List<Category>){
    
    LazyVerticalGrid(GridCells.Fixed(2) , modifier = Modifier.fillMaxSize()){

    }
}
