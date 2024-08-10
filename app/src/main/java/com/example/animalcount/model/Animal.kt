package com.example.animalcount.model

data class Animal(
    val id: String,
    val name: String,
    val count: Int = 0,
    val emoji: String,
)
