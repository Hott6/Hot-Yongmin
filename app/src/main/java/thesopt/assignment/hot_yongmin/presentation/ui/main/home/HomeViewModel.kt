package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers

class HomeViewModel : ViewModel() {

    val followersData = MutableLiveData<List<ResponseGithubFollowers>>()
    val call: Call<List<ResponseGithubFollowers>> =
        ServiceCreator.githubService.getGithubFollowers("briandr97")

    /*fun initNetwork(){
        call.enqueueUtil(
            onSuccess = {
                followersData.value=it
            },
            onError = {
                Log.d("server", "오류")
            }
        )
    }*/

    fun connectNetwork() {
        val call: Call<List<ResponseGithubFollowers>> =
            ServiceCreator.githubService.getGithubFollowers("briandr97")
        call.enqueue(object : Callback<List<ResponseGithubFollowers>> {
            override fun onResponse(
                call: Call<List<ResponseGithubFollowers>>,
                response: Response<List<ResponseGithubFollowers>>
            ) {
                if (response.isSuccessful) {
                    Log.d("followersServer", "onResponse success")
                    followersData.value = response.body()
                    Log.d("asdf", "${response.body()}")
                } else {
                    Log.d("followersServer", "onResponse fail")
                }
            }

            override fun onFailure(call: Call<List<ResponseGithubFollowers>>, t: Throwable) {
                Log.d("followersServer", "onFailure")
                Log.d("followersServer", "${t.message}")
            }
        })
    }
}