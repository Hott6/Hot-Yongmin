package thesopt.assignment.hot_yongmin.data.remote.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers

interface GithubService {
    @GET("{githubId}/followers")
    fun getGithubFollowers(
        @Path("githubId") githubId:String
    ): Call<List<ResponseGithubFollowers>>

    @GET("{githubId}/following")
    fun getGithubFollowing(
        @Path("githubId") githubId:String
    ): Call<List<ResponseGithubFollowers>>
}