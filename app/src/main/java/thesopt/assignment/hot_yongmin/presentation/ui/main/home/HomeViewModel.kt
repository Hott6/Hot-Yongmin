package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import thesopt.assignment.hot_yongmin.presentation.util.enqueueUtil

class HomeViewModel : ViewModel() {

    private var _followersData = MutableLiveData<List<ResponseGithubFollowers>>()
    val followersData: LiveData<List<ResponseGithubFollowers>> get() = _followersData

    private var _followingData = MutableLiveData<List<ResponseGithubFollowers>>()
    val followingData: LiveData<List<ResponseGithubFollowers>> get() = _followingData

    private val id = GithubSharedPreferences.loginId ?: ""

    fun initFollowersNetwork() {
        val call: Call<List<ResponseGithubFollowers>> =
            ServiceCreator.githubService.getGithubFollowers(id)
        call.enqueueUtil(
            onSuccess = { _followersData.value = it },
            onError = { Log.d("server", "오류") }
        )
    }

    fun initFollowingNetwork() {
        val call: Call<List<ResponseGithubFollowers>> =
            ServiceCreator.githubService.getGithubFollowing(id)
        call.enqueueUtil(
            onSuccess = { _followingData.value = it },
            onError = { Log.d("server", "오류") }
        )
    }
}