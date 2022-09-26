package com.commandiron.toprated10films.domain.preferences

interface MyPreferences {
    fun saveShouldShowSplash(shouldShow: Boolean)
    fun loadShouldShowSplash(): Boolean

    companion object {
        const val KEY_SHOULD_SHOW_SPLASH = "should_show_splash"
    }
}