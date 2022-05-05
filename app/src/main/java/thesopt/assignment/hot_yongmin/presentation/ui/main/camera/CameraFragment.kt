package thesopt.assignment.hot_yongmin.presentation.ui.main.camera

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import thesopt.assignment.hot_yongmin.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {
    private var _binding : FragmentCameraBinding? = null
    private val binding get() = _binding!!
    private val getContent=registerForActivityResult(ActivityResultContracts.GetContent()){ uri:Uri?->
        binding.ivGalleryImage.setImageURI(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCameraBinding.inflate(layoutInflater)
        binding.btnSendImage.setOnClickListener{
            selectImage()
        }
        return binding.root
    }

    private fun selectImage(){
        getContent.launch("image/*")
    }
}