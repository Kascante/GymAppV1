package com.example.gymapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaBienvenida(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a GymApp", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("formulario") }) {
            Text("Comenzar")
        }
    }
}
