package com.ahoy.livecoding.home.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ahoy.livecoding.R
import com.ahoy.livecoding.databinding.FragmentHomeBinding
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.home.viewmodel.HomeViewModel
import com.ahoy.livecoding.util.addDivider
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeBinding.inflate(inflater,container,false).apply {
            setup(this)
        }.root
    }

    private fun setup(fragmentHomeBinding: FragmentHomeBinding) {
        fragmentHomeBinding.apply {
            binding = this
            lifecycleOwner = viewLifecycleOwner
            viewModel = homeViewModel
            addDivider()
            adapter = HomeAdapter {
                navigateToDetails(it)
            }
        }
    }

    private fun navigateToDetails(it: ElectricStation) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                it
            )
        )
    }

    private fun addDivider() {
        binding.recyclerview.addDivider()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings){
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}