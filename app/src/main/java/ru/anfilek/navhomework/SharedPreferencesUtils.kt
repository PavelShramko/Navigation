package ru.anfilek.navhomework

import android.content.Context

object SharedPreferencesUtils {

    private const val SHARED_PREFERENCE_NAME = "common"

    fun getSharedPreferences(context: Context) =
        context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
}