package com.example.kompasandroidassessment.feature.presentation.detail.fragment

import BundleKey.ARGUMENT
import Error.MESSAGE_SUCCESS
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kompasandroidassessment.R
import com.example.kompasandroidassessment.core.utils.UiEvent
import com.example.kompasandroidassessment.databinding.FragmentDetailBinding
import com.example.kompasandroidassessment.feature.domain.adapter.detail.DetailRepoAdapter
import com.example.kompasandroidassessment.feature.presentation.detail.viewmodel.DetailViewModel
import com.example.kompasandroidassessment.utils.asString
import com.example.kompasandroidassessment.utils.loadImage
import com.example.kompasandroidassessment.utils.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding as FragmentDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var detailRepoAdapter: DetailRepoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initInstance(view)
        super.onViewCreated(binding.root, savedInstanceState)
        initAdapter()
        initArgument()
        initLaunch()
    }

    private fun initInstance(view: View) {
        _binding = FragmentDetailBinding.bind(view)
        detailRepoAdapter = DetailRepoAdapter.instance()
    }

    private fun initAdapter() {
        detailRepoAdapter.let { adapter ->
            binding.rvRepo.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(requireContext())
                ViewCompat.setNestedScrollingEnabled(this, true)
            }
        }
    }

    private fun initArgument() {
        arguments?.getString(ARGUMENT)?.let { username ->
            viewModel.getDetailUser(username)
            viewModel.getDetailRepo(username)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initLaunch() {
        lifecycleScope.launchWhenStarted {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.state.collectLatest { result ->
                        result.detailItem?.let { detailData ->
                            binding.ivAvatar.loadImage(detailData.avatarUrl ?: "")
                            binding.tvName.text = detailData.login
                            binding.tvUsername.text = if (detailData.twitterUsername == null) "Twitter is Not Available" else "@${detailData.twitterUsername}"
                            binding.tvOverview.text = if (detailData.bio == null) "Bio is Not Available" else  detailData.bio.toString()
                        }
                        Log.e(this@DetailFragment.toString(), "message: ${result.detailRepoItem}")
                        detailRepoAdapter.differ.submitList(result.detailRepoItem)
                    }
                }
                launch {
                    viewModel.uiEvent.collectLatest { event ->
                        when(event) {
                            is UiEvent.ShowSnackbar -> {
                                snackbar(
                                    binding.root,
                                    event.message.asString(requireContext()),
                                    MESSAGE_SUCCESS
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}