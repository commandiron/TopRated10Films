package com.commandiron.toprated10films.ui.model

import kotlin.random.Random

data class Year(
    val name: String,
    val color: Long = Random.nextLong(0xFFFFFFFF),
    val imageUrl: String? = null
) {
    companion object {
        val yearList = generateYears()
        private fun generateYears(): List<Year> {
            val years = mutableListOf<Year>()
            (0..122).forEach {
                years.add(Year(name = (2022 - it).toString()))
            }
            return years
        }
    }

}
