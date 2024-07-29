package com.tneagu.recipeapp.feature.recipelist.data.model

data class GetRecipeResponseDto (
    val results: List<RecipeDto>,
    val totalResults: Int,
)