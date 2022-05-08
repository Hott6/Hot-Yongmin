package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var position = FOLLOWER_FRAGMENT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProfileBinding.inflate(layoutInflater)
        initImage()
        initTransactionEvent()
        return binding.root
    }

    private fun initImage(){
        Glide.with(this).load(R.drawable.profile_emoji)
            .circleCrop().into(binding.ivProfile)
    }

    private fun initTransactionEvent(){
        val followerFragment = FollowerFragment()
        val repoFragment = RepoFragment()
        childFragmentManager.beginTransaction().add(R.id.fcv_list, followerFragment).commit()
        binding.btnFollowerList.isSelected=true
        binding.btnRepoList.isSelected = false

        binding.btnFollowerList.setOnClickListener{
            val transaction = childFragmentManager.beginTransaction()
            if(position== REPO_FRAGMENT){
                transaction.replace(R.id.fcv_list, followerFragment).commit()
                position = FOLLOWER_FRAGMENT
                binding.btnFollowerList.isSelected = true
                binding.btnRepoList.isSelected = false
            }
        }
        binding.btnRepoList.setOnClickListener{
            val transaction = childFragmentManager.beginTransaction()
            if(position== FOLLOWER_FRAGMENT){
                transaction.replace(R.id.fcv_list, repoFragment).commit()
                position = REPO_FRAGMENT
                binding.btnFollowerList.isSelected = false
                binding.btnRepoList.isSelected = true
            }
        }
    }

    companion object{
        const val FOLLOWER_FRAGMENT = 1
        const val REPO_FRAGMENT = 2
    }
}