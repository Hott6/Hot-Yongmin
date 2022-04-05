package thesopt.assignment.hot_yongmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import thesopt.assignment.hot_yongmin.ContextExt.shortToast
import thesopt.assignment.hot_yongmin.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signUpIntent = Intent(this, SignUpActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)
        val receiveIntent = intent

        binding.btnSignup.setOnClickListener{
            startActivity(signUpIntent)
        }
        binding.btnLogin.setOnClickListener{
            if(binding.etId.text.isEmpty() or binding.etPw.text.isEmpty()){
                this.shortToast("아이디/비밀번호를 확인해주세요")
            }
            else{
                startActivity(homeIntent)
                this.shortToast("로그인 성공")
            }
        }

        binding.etId.setText(receiveIntent.getStringExtra("id"))
        binding.etPw.setText(receiveIntent.getStringExtra("pw"))
    }
}