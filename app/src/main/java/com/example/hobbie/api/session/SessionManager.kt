package com.example.hobbie.api.session

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs =
        context.getSharedPreferences(Constants.PREFS_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveAuthToken(token: String) {
        Log.d("SessionManager", "saveAuthToken: $token")
        prefs.edit().putString(Constants.AUTH_TOKEN, token).apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(Constants.AUTH_TOKEN, null)
    }

    fun clearAuthToken() {
        prefs.edit().remove(Constants.AUTH_TOKEN).apply()
    }
}