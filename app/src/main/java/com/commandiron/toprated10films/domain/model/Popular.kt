package com.commandiron.toprated10films.domain.model

import com.commandiron.toprated10films.ui.model.Category

data class Popular(
    val id: Int,
    val title: String,
    val imageUrl: String? = null,
    val color: Long? = null,
    val category: Category
)
