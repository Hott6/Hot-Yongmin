package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.entity.FollowerData
import thesopt.assignment.hot_yongmin.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()
        with(binding){
            rvFollower.adapter = followerAdapter
            //rvFollower.addItemDecoration(VerticalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_15), 1))
            rvFollower.addItemDecoration(HorizontalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_30), 1))
        }

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData("권용민", "30기 OB", R.drawable.altongmon),
                FollowerData("김수빈", "30기 OB", R.drawable.kkomongul),
                FollowerData("최윤정", "30기 YB", R.drawable.mazayong),
                FollowerData("최유리", "30기 YB", R.drawable.chicorita),
                FollowerData("이준원", "30기 YB", R.drawable.kkojimo),
                FollowerData("이강민", "30기 파트장", R.drawable.dandaegi)
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}