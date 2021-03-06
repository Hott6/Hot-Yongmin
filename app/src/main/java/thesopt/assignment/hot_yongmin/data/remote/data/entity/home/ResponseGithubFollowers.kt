package thesopt.assignment.hot_yongmin.data.remote.data.entity.home

import com.google.gson.annotations.SerializedName

data class ResponseGithubFollowers(
    @SerializedName("login")
    val id: String,
    @SerializedName("avatar_url")
    val profileImage: String,
    @SerializedName("html_url")
    val profileLink: String,
)