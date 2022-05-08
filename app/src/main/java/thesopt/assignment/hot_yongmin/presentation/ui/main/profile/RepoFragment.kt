package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.entity.RepoData
import thesopt.assignment.hot_yongmin.databinding.FragmentRepoBinding

class RepoFragment : Fragment() {
    private var _binding : FragmentRepoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : RepoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepoBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        val repoAdapter= RepoAdapter()
        with(binding){
            rvRepo.adapter=repoAdapter
            rvRepo.addItemDecoration(VerticalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_15), 2))
            rvRepo.addItemDecoration(HorizontalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_30), 2))
        }
        repoAdapter.repoList.addAll(
            listOf(
                RepoData("Hot6 Hot-yongmin", "30기 안드로이드 과제 레포"),
                RepoData("Catholic Library Seat", "창의적 미디어 프로젝트 설계 레포"),
                RepoData("Algorithm", "알고리즘 레포"),
                RepoData("android-yongmin", "29기 안드로이드 과제 레포"),
                RepoData("woorido-aos", "솝커톤 우리도 레포"),
                RepoData("BeMyPlan-AOS", "비마플 안드 레포"),
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}