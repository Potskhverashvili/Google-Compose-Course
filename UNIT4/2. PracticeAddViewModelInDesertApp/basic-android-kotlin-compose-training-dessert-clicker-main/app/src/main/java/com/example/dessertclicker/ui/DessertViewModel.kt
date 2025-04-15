package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.R
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(DessertUiState(currentDessertImageId = R.drawable.cupcake))
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun updateStates() {
        val newDessertsSold = _uiState.value.dessertsSold + 1
        val dessertToShow =
            determineDessertToShow(Datasource.dessertList, newDessertsSold)

        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue + dessertToShow.price,
                dessertsSold = newDessertsSold,
                currentDessertImageId = dessertToShow.imageId
            )
        }
    }

    private fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        return dessertToShow
    }
}