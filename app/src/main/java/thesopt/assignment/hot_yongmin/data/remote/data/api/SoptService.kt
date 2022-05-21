package thesopt.assignment.hot_yongmin.data.remote.data.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.RequestSignIn
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.RequestSignUp
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.ResponseSignIn
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.ResponseSignUp

interface SoptService {
    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}