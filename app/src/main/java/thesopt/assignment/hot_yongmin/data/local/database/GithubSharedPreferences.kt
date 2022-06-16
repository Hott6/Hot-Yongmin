package thesopt.assignment.hot_yongmin.data.local.database

import android.content.Context
import android.content.SharedPreferences

object GithubSharedPreferences {

    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"
    private const val LOGIN_ID = "LOGIN_ID"
    private const val ONBOARDING = "ONBOARDING"
    private lateinit var loginPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        loginPreferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        editor = loginPreferences.edit()
    }

    var autoLogin: Boolean
        get() = loginPreferences.getBoolean(AUTO_LOGIN, false)
        set(value) = editor.putBoolean(AUTO_LOGIN, value).apply()

    var onBoarding: Boolean
        get() = loginPreferences.getBoolean(ONBOARDING, false)
        set(value) = editor.putBoolean(ONBOARDING, value).apply()

    var loginId: String?
        get() = loginPreferences.getString(LOGIN_ID, "")
        set(value) = editor.putString(LOGIN_ID, value).apply()

    fun setLogout() {
        editor.remove(AUTO_LOGIN).apply()
    }

    fun clear() {
        editor.clear().apply()
    }
}