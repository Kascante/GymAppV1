package com.example.gymapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.gymapp.screens.*
import com.example.gymapp.viewmodel.FormularioViewModel

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val viewModel: FormularioViewModel = viewModel()

    NavHost(navController = navController, startDestination = "bienvenida") {
        composable("bienvenida") { PantallaBienvenida(navController) }
        composable("formulario") { FormularioScreen(navController, viewModel) }
        composable("resultado") { ResultadoScreen(viewModel) }
    }
}