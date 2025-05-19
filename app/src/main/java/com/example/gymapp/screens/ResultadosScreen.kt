package com.example.gymapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp.viewmodel.FormularioViewModel
import com.example.gymapp.model.RoutineDetail

@Composable
fun ResultadoScreen(viewModel: FormularioViewModel) {
    val rutina = viewModel.obtenerRutinaDesdeBD()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Tu rutina recomendada:", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        rutina?.let { rutinaDetail: RoutineDetail -> // Especificar el tipo aquí
            Text(text = rutinaDetail.nombre, style = MaterialTheme.typography.body1)
        } ?: run {
            Text(text = "No hay rutina disponible", style = MaterialTheme.typography.body1)
        }
    }
}