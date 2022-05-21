package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator

class HomeViewModel : ViewModel() {

    val followersData = MutableLiveData<List<ResponseGithubFollowers.Data>>()

    fun connectNetwork(){
        val call : Call<ResponseGithubFollowers> = ServiceCreator.githubService.getGithubFollowers("briandr97")
        call.enqueue(object : Callback<ResponseGithubFollowers>{
            override fun onResponse(
                call: Call<ResponseGithubFollowers>,
                response: Response<ResponseGithubFollowers>
            ) {
                if(response.isSuccessful){
                    Log.d("followersServer", "onResponse success")
                     followersData.value = response.body()?.data
                }else{
                    Log.d("followersServer", "onResponse fail")
                }
            }

            override fun onFailure(call: Call<ResponseGithubFollowers>, t: Throwable) {
                Log.d("followersServer", "onFailure")
            }
        })
    }
}