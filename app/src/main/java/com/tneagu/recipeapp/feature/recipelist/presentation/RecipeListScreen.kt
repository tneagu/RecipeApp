package com.tneagu.recipeapp.feature.recipelist.presentation

import RecipeItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.tneagu.recipeapp.core.data.model.Recipe

@Composable
fun RecipeListRoute(
    onRecipeClick: () -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel(),
) {
    val recipePagingItems = viewModel.recipesFlow.collectAsLazyPagingItems()
    RecipeListScreen(recipePagingItems)
}

@Composable
private fun RecipeListScreen(
    lazyPagingItems: LazyPagingItems<Recipe>,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(lazyPagingItems.itemCount) { index ->
                lazyPagingItems[index]?.let { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }

            lazyPagingItems.apply {
                when (loadState.append) {
                    is LoadState.Loading -> {
                        item { CircularProgressIndicator() }
                    }

                    is LoadState.Error -> {
                        val e = loadState.append as LoadState.Error
                        item {
                            Text(
                                text = e.error.localizedMessage ?: "Unknown error",
                                modifier = Modifier.padding(8.dp)
                            )
                            Button(onClick = { retry() }) {
                                Text("Retry")
                            }
                        }
                    }

                    is LoadState.NotLoading -> {}
                }
            }
        }


    }

}