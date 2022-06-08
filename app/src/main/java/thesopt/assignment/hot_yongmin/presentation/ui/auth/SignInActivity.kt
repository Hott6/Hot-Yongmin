package thesopt.assignment.hot_yongmin.presentation.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thesopt.assignment.hot_yongmin.presentation.util.ContextExt.shortToast
import thesopt.assignment.hot_yongmin.databinding.ActivitySignInBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.MainActivity
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.RequestSignIn
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.ResponseSignIn
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        GithubSharedPreferences.init(this)
        clickLogin()
        clickSignUp()
        setResultSignUp()

        setContentView(binding.root)
    }

    private fun loginNetwork(){
        val requestSignIn= RequestSignIn(
            email=binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )
        val call: Call<ResponseSignIn> = ServiceCreator.soptService.postLogin(requestSignIn)
        call.enqueue(object:Callback<ResponseSignIn>{
            override fun onResponse(
                call: Call<ResponseSignIn>,
                response: Response<ResponseSignIn>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    this@SignInActivity.shortToast("${data?.email}")
                    checkAutoLogin()
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    this@SignInActivity.shortToast("onResponse isSuccessful.")
                }
                else{
                    this@SignInActivity.shortToast("onResponse not Successful")
                }
            }

           override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
               Log.d("network", "error:$t")
               this@SignInActivity.shortToast("onFailure")
            }
        })
    }

    private fun setResultSignUp(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode== RESULT_OK){
                val id = result.data?.getStringExtra("id")
                val pw = result.data?.getStringExtra("pw")
                binding.etId.setText(id)
                binding.etPw.setText(pw)
            }
        }
    }

    private fun checkAutoLogin(){
        if(binding.cbAutoLogin.isChecked){
            GithubSharedPreferences.setAutoLogin(true)
            shortToast("자동로그인 되었습니다!")
        }
        else{
            GithubSharedPreferences.setAutoLogin(false)
        }
    }

    private fun clickSignUp(){
        binding.tvSignup.setOnClickListener{
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(signUpIntent)
        }
    }

    private fun clickLogin(){
        binding.btnLogin.setOnClickListener{
            if(binding.etId.text.isEmpty() or binding.etPw.text.isEmpty()){
                this.shortToast("아이디/비밀번호를 확인해주세요")
            }
            else
                loginNetwork()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "SignIn die")
    }
}