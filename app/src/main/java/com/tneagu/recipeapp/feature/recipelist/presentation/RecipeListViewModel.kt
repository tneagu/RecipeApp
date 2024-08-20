package com.tneagu.recipeapp.feature.recipelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.usecase.GetRecipesUseCase
import com.tneagu.recipeapp.feature.recipelist.presentation.model.RecipeListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase,
) : ViewModel() {
    val recipesFlow: Flow<PagingData<Recipe>> = getRecipesUseCase.execute()
        .cachedIn(viewModelScope)
}