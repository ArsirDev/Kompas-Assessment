package com.example.kompasandroidassessment.feature.presentation.home.fragment

import Error.MESSAGE_SUCCESS
import android.app.Activity
import android.content.Context
import android.os.Bundle
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
import com.example.kompasandroidassessment.databinding.FragmentHomeBinding
import com.example.kompasandroidassessment.feature.domain.adapter.search.SearchAdapter
import com.example.kompasandroidassessment.feature.presentation.home.event.HomeEvent
import com.example.kompasandroidassessment.feature.presentation.home.viewmodel.HomeViewModel
import com.example.kompasandroidassessment.utils.asString
import com.example.kompasandroidassessment.utils.isLastVisible
import com.example.kompasandroidassessment.utils.onValidation
import com.example.kompasandroidassessment.utils.removeView
import com.example.kompasandroidassessment.utils.showView
import com.example.kompasandroidassessment.utils.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding as FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var searchAdapter: SearchAdapter

    private lateinit var listener: OnDataPass

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            listener = context as OnDataPass
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        searchAdapter = SearchAdapter.instance()
        super.onViewCreated(binding.root, savedInstanceState)
        iniLaunch()
        initEvent()
        initAdapter()
        initPagination()
        initSwipeRefresh()
    }

    private fun initSwipeRefresh() {
        binding.root.setOnRefreshListener {
            val username = binding.etSearch.text.toString().trim()
            if (username.onValidation()){
                viewModel.onEvent(HomeEvent.SearchRefresh)
                binding.root.isRefreshing = false
            } else {
                binding.root.isRefreshing = false
            }
        }
    }

    private fun initPagination() {
        binding.rvUserList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (isLastVisible(recyclerView, true)) {
                    viewModel.onEvent(HomeEvent.LoadMore)
                }
            }
        })
    }

    private fun initEvent() {
        binding.etLayout.setStartIconOnClickListener {
            val user = binding.etSearch.text.toString().trim()
            viewModel.onEvent(
                event = HomeEvent.SearchUser(user)
            )
        }
    }

    private fun initAdapter() {
        searchAdapter.let { adapter ->
            binding.rvUserList.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(requireContext())
                ViewCompat.setNestedScrollingEnabled(this, true)
            }

            adapter.setOnItemClickListener { username ->
                listener.onDataPass(username)
            }
        }
    }

    private fun iniLaunch() {
        lifecycleScope.launchWhenStarted {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.state.collectLatest { state ->
                        if (state.isLoading) {
                            binding.pbLoading.showView()
                        } else {
                            binding.pbLoading.removeView()
                            searchAdapter.differ.submitList(state.listSearch)
                        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnDataPass {
        fun onDataPass(username: String)
    }

}