package com.example.learningandroid

import java.io.Serializable


data class HamburgerItem(
    var meat: String,
    var cheese: String,
    var onion: String,
    var lettuce: String
) : Serializable