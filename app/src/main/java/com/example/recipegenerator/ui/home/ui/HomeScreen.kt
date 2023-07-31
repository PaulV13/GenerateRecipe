package com.example.recipegenerator.ui.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun HomeScreen(viewModel: HomeViewModel){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
        ) {

        val ingredient: String by viewModel.ingredient.observeAsState(initial = "")
        val ingredients: MutableList<String> by viewModel.ingredients.observeAsState(initial = mutableListOf())

        Column(modifier = Modifier.fillMaxWidth()){
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = ingredient,
                onValueChange = { viewModel.setIngredient(it) },
                keyboardActions = KeyboardActions(
                    onDone = {
                        viewModel.addIngredient(ingredient)
                        viewModel.setIngredient("")
                    }
                ),
                label = { Text(text =  "Ingredient") },
                isError = ingredient.isEmpty(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.addIngredient(ingredient)
                    viewModel.setIngredient("")
                }) {
                Text(text = "Add ingredient")
            }

            Spacer(modifier = Modifier.height(16.dp))

            ingredients.forEach { i ->
                Text(text = i)
            }
        }
        
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Generate recipe")
        }
    }

}