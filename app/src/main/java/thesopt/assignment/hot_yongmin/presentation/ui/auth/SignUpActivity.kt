package thesopt.assignment.hot_yongmin.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thesopt.assignment.hot_yongmin.databinding.ActivitySignUpBinding
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.RequestSignUp
import thesopt.assignment.hot_yongmin.data.remote.data.entity.auth.ResponseSignUp
import thesopt.assignment.hot_yongmin.data.remote.data.api.ServiceCreator
import thesopt.assignment.hot_yongmin.presentation.util.ContextExt.shortToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickSignUp()
    }

    private fun clickSignUp() {
        binding.btnLogin.setOnClickListener {
            if (binding.etId.text.isEmpty() or binding.etName.text.isEmpty() or binding.etPw.text.isEmpty()) {
                this.shortToast("입력되지 않은 정보가 있습니다")
            } else {
                signUpNetWork()
            }
        }
    }

    private fun sendIntent(){
        val intent = Intent(this, SignInActivity::class.java)
        intent.putExtra("id", binding.etId.text.toString())
        intent.putExtra("pw", binding.etPw.text.toString())
        setResult(RESULT_OK, intent)
        this.shortToast("회원가입 되었습니다.")
        finish()
    }

    private fun signUpNetWork() {
        val requestSignUp = RequestSignUp(
            binding.etName.toString(),
            binding.etId.toString(),
            binding.etPw.toString()
        )

        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)
        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    this@SignUpActivity.shortToast("서버 통신 성공: ${data?.message}")
                    sendIntent()
                } else {
                    this@SignUpActivity.shortToast("서버 통신 실패 : ${response.body()?.message}")
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                this@SignUpActivity.shortToast("서버 통신 실패 : onFailure")
            }
        })
    }
}