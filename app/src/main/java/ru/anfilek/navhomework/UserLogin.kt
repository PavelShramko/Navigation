package ru.anfilek.navhomework

import android.content.Context
import androidx.core.content.edit

class UserLogin(context: Context) {
    private companion object {
        const val USER_LOGIN_FLAG = "USER_LOGIN"
    }

    private val sharedPreferences = SharedPreferencesUtils.getSharedPreferences(context)

    fun isUserLoggedIn(): Boolean = sharedPreferences.getBoolean(USER_LOGIN_FLAG, false)

    fun setUserLoggedIn() = sharedPreferences.edit(true) { putBoolean(USER_LOGIN_FLAG, true) }

    fun setUserLoggedOut() = sharedPreferences.edit(true) { putBoolean(USER_LOGIN_FLAG, false) }

}