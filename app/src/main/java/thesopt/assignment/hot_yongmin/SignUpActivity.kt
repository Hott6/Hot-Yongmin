package thesopt.assignment.hot_yongmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import thesopt.assignment.hot_yongmin.ContextExt.shortToast
import thesopt.assignment.hot_yongmin.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SignInActivity::class.java)
        binding.btnLogin.setOnClickListener{
            if(binding.etId.text.isEmpty() or binding.etName.text.isEmpty() or binding.etPw.text.isEmpty()){
                this.shortToast("입력되지 않은 정보가 있습니다")
            }
            else{
                intent.putExtra("id", binding.etId.text.toString())
                intent.putExtra("pw", binding.etPw.text.toString())
                startActivity(intent)
                this.shortToast("회원가입 되었습니다.")
                finish()
            }
        }
    }
}