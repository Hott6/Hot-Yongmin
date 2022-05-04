package thesopt.assignment.hot_yongmin.presentation.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import thesopt.assignment.hot_yongmin.presentation.util.ContextExt.shortToast
import thesopt.assignment.hot_yongmin.databinding.ActivitySignInBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.MainActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickLogin()
        clickSignUp()
        setResultSignUp()
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

    private fun clickSignUp(){
        binding.btnSignup.setOnClickListener{
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(signUpIntent)
        }
    }

    private fun clickLogin(){
        binding.btnLogin.setOnClickListener{
            val homeIntent = Intent(this, MainActivity::class.java)
            if(binding.etId.text.isEmpty() or binding.etPw.text.isEmpty()){
                this.shortToast("아이디/비밀번호를 확인해주세요")
            }
            else{
                startActivity(homeIntent)
                this.shortToast("로그인 성공")
            }
        }
    }

}