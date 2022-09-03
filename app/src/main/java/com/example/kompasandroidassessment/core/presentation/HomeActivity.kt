package com.example.kompasandroidassessment.core.presentation

import BundleKey.ARGUMENT
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kompasandroidassessment.R
import com.example.kompasandroidassessment.databinding.ActivityHomeBinding
import com.example.kompasandroidassessment.feature.presentation.home.fragment.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), HomeFragment.OnDataPass {

    private var _binding: ActivityHomeBinding? = null

    private val binding get() = _binding as ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDataPass(username: String) {
        findNavController(R.id.fragment_container).navigate(R.id.detailFragment, bundleOf(ARGUMENT to username))
    }
}