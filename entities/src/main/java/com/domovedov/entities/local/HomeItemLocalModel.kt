package com.domovedov.entities.local

data class HomeItemLocalModel(
    val homeIcon: List<String>,
    var isFavorites: Boolean,
    val name: String,
    val descriptionBlackName: String,
    val description: String,
    val size: String,
    val price: String
)
