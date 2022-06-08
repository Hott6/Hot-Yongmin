package thesopt.assignment.hot_yongmin.data.remote.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL_SOPT = "http://13.124.62.236"
    private const val BASE_URL_GITHUB = "https://api.github.com/users/"

    private val retrofit_sopt:Retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL_SOPT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofit_github:Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL_GITHUB)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService : SoptService = retrofit_sopt.create(SoptService::class.java)
    val githubService : GithubService = retrofit_github.create(GithubService::class.java)
}