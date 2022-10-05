package com.example.homework_3_7

import java.io.Serializable

data class Character(
    val name: String,
    val status: String,
    val image: String
) : Serializable
