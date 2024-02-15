package com.ayush.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController , startDestination = Screen.RecipeScreen.route){

        composable(route = Screen.RecipeScreen.route){
            //this part is responsible for passing the data from current screen to the detail screen.
            //it utilizes the savedStateHandle , which is a component if the compose navigation framework

            RecipeScreen(viewState = viewState , navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat" , it)
                navController.navigate(Screen.DetailScreen.route)
            } )

        }
        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?:Category("" , "" , "" , "")
            CategoryDetailScreen(category = category )

        }
    }

}