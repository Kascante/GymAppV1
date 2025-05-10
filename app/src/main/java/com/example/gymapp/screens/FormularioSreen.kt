package com.example.gymapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymapp.components.*
import com.example.gymapp.model.FormularioRespuestas
import com.example.gymapp.viewmodel.FormularioViewModel

@Composable
fun FormularioScreen(navController: NavController, viewModel: FormularioViewModel) {
    val context = LocalContext.current

    var peso by remember { mutableStateOf<Int?>(null) }
    var altura by remember { mutableStateOf<Int?>(null) }
    var cintura by remember { mutableStateOf<Int?>(null) }
    var nivel by remember { mutableStateOf<String?>(null) }
    var problema by remember { mutableStateOf<String?>(null) }
    var dias by remember { mutableStateOf<Int?>(null) }
    var objetivo by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("¿Cuánto pesas?")
        DropdownMenuNumber(50..120) { peso = it }

        Text("¿Cuánto mides?")
        DropdownMenuNumber(140..200) { altura = it }

        Text("¿Cuánto mide tu cintura?")
        DropdownMenuNumber(70..150) { cintura = it }

        Text("Nivel de experiencia")
        DropdownMenuString(listOf("iniciación", "intermedio", "avanzado")) { nivel = it }

        Text("¿Tienes algún problema físico?")
        DropdownMenuString(listOf("espalda", "ninguno")) { problema = it }

        Text("¿Cuántos días entrenas?")
        DropdownMenuNumber(1..7) { dias = it }

        Text("¿Cuál es tu objetivo?")
        DropdownMenuString(listOf("ganar fuerza", "hipertrofia", "definición", "pérdida de peso")) { objetivo = it }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val r = FormularioRespuestas(peso, altura, cintura, nivel, problema, dias, objetivo)
            if (!r.esCompleto()) {
                Toast.makeText(context, "Completa todas las respuestas", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.actualizarRespuestas(r)
                navController.navigate("resultado")
            }
        }) {
            Text("Continuar")
        }
    }
}
