package com.tneagu.recipeapp.feature.recipelist.data.model

import com.tneagu.recipeapp.core.data.model.Recipe

data class RecipeDto(
    val id: Int,
    val title: String,
    val image: String,
) {

    fun toRecipe(): Recipe {
        return Recipe(
            id = id,
            name = title,
            imageUrl = image,
        )
    }
}