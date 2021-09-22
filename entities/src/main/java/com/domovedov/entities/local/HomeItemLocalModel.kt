package com.domovedov.entities.local

data class HomeItemLocalModel(
    val homeIcon: List<String>,
    val isFavorites: Boolean,
    val name: String,
    val descriptionBlackName: String,
    val description: String,
    val size: String,
    val price: String
)
