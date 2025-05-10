package com.example.gymapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp.viewmodel.FormularioViewModel

@Composable
fun ResultadoScreen(viewModel: FormularioViewModel) {
    val rutina = viewModel.obtenerRutinaDesdeBD()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Tu rutina recomendada:", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(rutina, style = MaterialTheme.typography.body1)
    }
}
