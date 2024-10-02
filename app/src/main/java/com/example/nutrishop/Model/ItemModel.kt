package com.example.nutrishop.Model


data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: String = "",
    var price: Double = 0.0,
    var numberInCart: Int = 0,
    var rating: Double = 0.0,
    var nutrients: MutableList<Nutrient> = mutableListOf()

    )

