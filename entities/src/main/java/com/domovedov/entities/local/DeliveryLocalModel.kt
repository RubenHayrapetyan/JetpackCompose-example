package com.domovedov.entities.local

data class DeliveryLocalModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    var isSelected: Boolean
)
