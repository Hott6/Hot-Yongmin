package thesopt.assignment.hot_yongmin.presentation.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.databinding.FragmentOnboarding3Binding

class Onboarding3Fragment : Fragment() {
    private var _binding: FragmentOnboarding3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding3Binding.inflate(layoutInflater)
        binding.tvNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding3Fragment_to_signInActivity)
            GithubSharedPreferences.init(requireContext())
            GithubSharedPreferences.setOnboarding(true)
            activity?.finish()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}