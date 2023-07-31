package com.example.recipegenerator.ui.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _ingredient = MutableLiveData<String>()
    var ingredient: LiveData<String> = _ingredient

    private val _ingredients =  MutableLiveData<MutableList<String>>()
    var ingredients: LiveData<MutableList<String>> = _ingredients

    init {
        _ingredients.value = mutableListOf()
    }

    fun addIngredient(ingredient: String){
        if(ingredient.isNotEmpty()){
            ingredients.value?.add(ingredient)
        }
    }

    fun setIngredient(value: String){
        _ingredient.value = value
    }
}