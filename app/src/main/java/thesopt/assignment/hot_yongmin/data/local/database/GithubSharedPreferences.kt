package thesopt.assignment.hot_yongmin.data.local.database

import android.content.Context
import android.content.SharedPreferences

object GithubSharedPreferences {

    private const val STORAGE_KEY = "USER_AUTH"
    private const val STORAGE_KEY2 = "ONBOARDING"
    private const val AUTO_LOGIN = "AUTO_LOGIN"
    private const val ONBOARDING = "ONBOARDING"
    private lateinit var loginPreferences: SharedPreferences
    //private lateinit var onboardingPreferences : SharedPreferences

    fun init(context: Context) {
        loginPreferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        //onboardingPreferences = context.getSharedPreferences(STORAGE_KEY2, Context.MODE_PRIVATE)
    }

    fun getAutoLogin(): Boolean {
        return loginPreferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(value: Boolean) {
        loginPreferences.edit().putBoolean(AUTO_LOGIN, value).apply()
    }

    fun setLogout(context: Context) {
        //preferences=context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        loginPreferences.edit().remove(AUTO_LOGIN).clear().apply()
    }

    fun setOnboarding(value: Boolean) {
        loginPreferences.edit().putBoolean(ONBOARDING, value).apply()
    }

    fun getOnboarding(): Boolean {
        return loginPreferences.getBoolean(ONBOARDING, false)
    }
}