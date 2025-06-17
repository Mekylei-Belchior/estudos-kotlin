package com.mekylei.delivery.dao

import androidx.compose.runtime.mutableStateListOf
import com.mekylei.delivery.model.Product

class ProductDAO {

    companion object {
        val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }
}