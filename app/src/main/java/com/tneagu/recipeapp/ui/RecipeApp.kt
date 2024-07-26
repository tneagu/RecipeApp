package com.tneagu.recipeapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.tneagu.recipeapp.MainNavHost
import com.tneagu.recipeapp.R
import com.tneagu.recipeapp.ui.theme.PurpleGrey40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.recipes)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PurpleGrey40
                )
            )
        }
    ) { innerPadding ->
        // Content of your app goes here, use innerPadding to avoid overlapping with the top bar
        MainNavHost(
            navController = rememberNavController(),
            modifier = Modifier.padding(innerPadding),
        )
    }
}