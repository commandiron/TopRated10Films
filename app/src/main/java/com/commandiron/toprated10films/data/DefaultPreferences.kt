package com.commandiron.toprated10films.data

import android.content.SharedPreferences
import com.commandiron.toprated10films.domain.preferences.MyPreferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): MyPreferences {
    override fun saveShouldShowSplash(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(MyPreferences.KEY_SHOULD_SHOW_SPLASH, shouldShow)
            .apply()
    }

    override fun loadShouldShowSplash(): Boolean {
        return sharedPref.getBoolean(
            MyPreferences.KEY_SHOULD_SHOW_SPLASH,
            true
        )
    }

}