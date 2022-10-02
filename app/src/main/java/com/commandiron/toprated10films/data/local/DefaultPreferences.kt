package com.commandiron.toprated10films.data.local

import android.content.SharedPreferences
import com.commandiron.toprated10films.domain.preferences.AppPreferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): AppPreferences {
    override fun saveShouldShowSplash(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(AppPreferences.KEY_SHOULD_SHOW_SPLASH, shouldShow)
            .apply()
    }

    override fun loadShouldShowSplash(): Boolean {
        return sharedPref.getBoolean(
            AppPreferences.KEY_SHOULD_SHOW_SPLASH,
            true
        )
    }

    companion object {
        const val PREF_NAME = "shared_pref"
    }
}