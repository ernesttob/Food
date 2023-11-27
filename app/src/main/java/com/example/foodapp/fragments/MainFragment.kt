package com.example.foodapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.foodadapter.FoodAdapter
import com.example.foodapp.cacheoffoods.CacheOfFood
import com.example.foodapp.foodmodel.FoodModel
import com.example.foodapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val sharedPref: CacheOfFood by lazy {
        CacheOfFood(requireContext())
    }

    private val adapter: FoodAdapter by lazy {
        FoodAdapter(requireContext())
    }

    private var listOfFood: List<FoodModel> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewsAndAdapter()
    }

    private fun setupViewsAndAdapter() {
        val foodList = sharedPref.getAllFood()
        if (foodList.isNotEmpty()) {
            listOfFood = foodList
            adapter.updateList(foodList)
            binding.mainRv.adapter = adapter
            binding.addYourFoodTv.visibility = View.GONE
            binding.mainRv.visibility = View.VISIBLE
        } else {
            binding.addYourFoodTv.visibility = View.VISIBLE
            binding.mainRv.visibility = View.GONE
        }

    }
}