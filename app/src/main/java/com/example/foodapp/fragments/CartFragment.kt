package com.example.foodapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.databinding.FoodItemBinding
import com.example.foodapp.databinding.FragmentCartBinding
import com.example.foodapp.foodadapter.BasketAdapter

class CartFragment : Fragment() {

    private val binding: FragmentCartBinding by lazy {
        FragmentCartBinding.inflate(layoutInflater)
    }

    private val binding2: FoodItemBinding by lazy {
        FoodItemBinding.inflate(layoutInflater)
    }
    private val adapter:BasketAdapter by lazy {
        BasketAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }
}