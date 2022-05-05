package thesopt.assignment.hot_yongmin.presentation.ui.main.camera

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import thesopt.assignment.hot_yongmin.databinding.FragmentCameraBinding
import thesopt.assignment.hot_yongmin.presentation.util.ContextExt.shortToast

class CameraFragment : Fragment() {
    private var _binding : FragmentCameraBinding? = null
    private val binding get() = _binding!!
    val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){isGranted:Boolean ->
        if(isGranted){
            requireContext().shortToast("권한요청이 승인되었습니다.")
            selectImage()
        }
        else
            requireContext().shortToast("권한요청이 거절되었습니다.")
    }
    private val getContent=registerForActivityResult(ActivityResultContracts.GetContent()){ uri:Uri?->
        Glide.with(requireContext()).load(uri).into(binding.ivGalleryImage)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCameraBinding.inflate(layoutInflater)
        binding.btnSendImage.setOnClickListener{
            aboutPermission()
        }
        return binding.root
    }

    private fun aboutPermission() {
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
            requireContext().shortToast("권한이 이미 있습니다.")
            selectImage()
        }
        else if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
            requireContext().shortToast("권한이 없습니다.")
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun selectImage(){
        getContent.launch("image/*")
    }
}