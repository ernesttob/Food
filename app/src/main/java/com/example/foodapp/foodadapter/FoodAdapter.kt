package com.example.foodapp.foodadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.foodmodel.FoodModel
import com.example.foodapp.R
import com.example.foodapp.databinding.FoodItemBinding

class FoodAdapter(
    private val context: Context
):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private val foodList = mutableListOf<FoodModel>()

    fun updateList(foodList: List<FoodModel>){
        this.foodList.clear()
        this.foodList.addAll(foodList)
        notifyDataSetChanged()
    }

    inner class FoodViewHolder (
        private val binding: FoodItemBinding,
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(foodModel: FoodModel){
            binding.foodNameTv.text = foodModel.name
            binding.foodTypeTv.text = foodModel.type
            binding.foodPriceTv.text = foodModel.price
            Glide.with(binding.root).load(foodModel.imgUrl).into(binding.foodIv)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.food_item,
                parent,
                false)
        )
        return FoodViewHolder(binding)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int
    ) {
        holder.bind(foodList[position])
    }

}