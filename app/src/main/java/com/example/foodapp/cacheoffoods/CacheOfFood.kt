package com.example.foodapp.cacheoffoods

import android.content.Context
import com.example.foodapp.foodmodel.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val FOOD_SHARED_PREF = "FOOD_SHARED_PREF"

data class CacheOfFood(
    private val context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getAllFood(): List<FoodModel>{
        val gson = Gson()
        val json = sharedPreferences.getString(FOOD_SHARED_PREF, null)
        val type : Type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val foodList = gson.fromJson<List<FoodModel>>(json, type)
        return foodList ?: emptyList()
    }
    fun saveFood(foodModel: FoodModel){
        val foods = getAllFood().toMutableList()
        foods.add(0,foodModel)
        val foodGson = Gson().toJson(foods)
        sharedPreferences
            .edit()
            .putString(FOOD_SHARED_PREF,foodGson)
            .apply()
    }

}


