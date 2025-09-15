package com.mekylei.delivery.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.mekylei.delivery.dao.ProductDAO
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {
    private val dao = ProductDAO()
    private val _uiState = MutableStateFlow(ProductFormUiState())

    val uiState get() = _uiState.asStateFlow()

    val formatter = DecimalFormat("#.##")

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onPriceChange = {
                    val price = try {
                        formatter.format(BigDecimal(it))
                    } catch (_: IllegalArgumentException) {
                        if (it.isEmpty()) {
                            it
                        } else {
                            null
                        }
                    }
                    price?.let {
                        _uiState.value = _uiState.value.copy(
                            price = price
                        )
                    }
                },
                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(
                        description = it
                    )
                }
            )
        }
    }

    fun save() {
        _uiState.value.run {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }

            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            dao.save(product)
        }
    }
}