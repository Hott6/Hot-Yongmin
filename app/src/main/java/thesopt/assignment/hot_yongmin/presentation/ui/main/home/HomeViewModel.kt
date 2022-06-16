package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import thesopt.assignment.hot_yongmin.presentation.util.enqueueUtil

class HomeViewModel : ViewModel() {

    val followersData = MutableLiveData<List<ResponseGithubFollowers>>()
    private val id = GithubSharedPreferences.loginId ?: ""

    fun initNetwork() {
        val call: Call<List<ResponseGithubFollowers>> =
            ServiceCreator.githubService.getGithubFollowers(id)
        call.enqueueUtil(
            onSuccess = {
                followersData.value = it
            },
            onError = {
                Log.d("server", "오류")
            }
        )
    }
}