package com.example.foodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodapp.cacheoffoods.CacheOfFood
import com.example.foodapp.foodmodel.FoodModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentAddFoodBinding
import com.google.android.material.snackbar.Snackbar


class AddFoodFragment : Fragment() {

    private val binding: FragmentAddFoodBinding by lazy {
        FragmentAddFoodBinding.inflate(layoutInflater)
    }

    private val sharedPref: CacheOfFood by lazy {
        CacheOfFood(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addFoodBtn.setOnClickListener {
            saveFoods()
        }
    }

    private fun saveFoods() = binding.apply {
        if (foodTypeEt.text.isNotEmpty() && foodNameEt.text.isNotEmpty() && foodPriceEt.text.isNotEmpty() && foodIvUrlEt.text.isNotEmpty()) {
            val foodModel = FoodModel(
                type = foodTypeEt.text.toString(),
                name = foodNameEt.text.toString(),
                price = foodPriceEt.text.toString(),
                imgUrl = foodIvUrlEt.text.toString()
            )
            sharedPref.saveFood(foodModel = foodModel)
            findNavController().navigate(R.id.action_addFoodFragment_to_mainFragment)
        } else {
            showToastMessage("Заполните все поля")
        }
    }

    private fun showToastMessage(massage: String) {
        Snackbar.make(
            binding.root,
            massage,
            Snackbar.LENGTH_SHORT,
        ).show()
    }
}