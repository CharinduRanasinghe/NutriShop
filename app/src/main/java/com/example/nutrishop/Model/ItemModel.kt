package com.example.nutrishop.Model

import java.time.temporal.TemporalAmount

data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: String = "",
    var price: Double = 0.0,
    var numberInCart: Int = 0,
    var rating: Double = 0.0,
    var nutrients: MutableList<DetailsModel> = mutableListOf()



    )
