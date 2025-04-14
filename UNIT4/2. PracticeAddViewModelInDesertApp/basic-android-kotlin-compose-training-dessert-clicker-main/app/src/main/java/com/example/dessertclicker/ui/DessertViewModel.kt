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

    private val _uiState = MutableStateFlow(DessertUiState(currentDessertImageId = R.drawable.cupcake))
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun updateStates() {
        _uiState.update { currentState ->
            currentState.copy(
                dessertsSold = currentState.dessertsSold.inc(),
            )
        }

        val dessertToShow =
            determineDessertToShow(Datasource.dessertList, _uiState.value.dessertsSold)

        _uiState.update { currentState ->
            currentState.copy(
                revenue = dessertToShow.price,
                currentDessertImageId = dessertToShow.imageId
            )
        }
    }

    fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int// 1
    ): Dessert {
        var dessertToShow = desserts.first()

        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }
        return dessertToShow
    }
}