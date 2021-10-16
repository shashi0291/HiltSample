package com.example.hiltsample.list.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hiltsample.R
import com.example.hiltsample.databinding.FragmentPhotoListBinding
import com.example.hiltsample.list.viewmodel.PhotoListViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: PhotoListViewModel by viewModels()

    private var _binding: FragmentPhotoListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        setObservers()
    }

    private fun setObservers() {
        viewModel.photoList.observe(viewLifecycleOwner, {
            println("${it.size}")
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}