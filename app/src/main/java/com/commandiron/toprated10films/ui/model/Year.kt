package com.commandiron.toprated10films.ui.model

import kotlin.random.Random

data class Year(
    val name: String,
    val color: Long,
    val imageUrl: String? = null
) {
    companion object {
        val yearList = generateYears()
        private fun generateYears(): List<Year> {
            val years = mutableListOf<Year>()
            (0..122).forEach {
                years.add(
                    Year(
                        name = (2022 - it).toString(),
                        color = Random.nextLong(0xFFFFFFFF)
                    )
                )
            }
            return years
        }
    }

}
