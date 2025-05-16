package com.example.gymapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gymapp.model.FormularioRespuestas
import com.example.gymapp.model.RoutineResponse
import com.example.gymapp.repository.RutinaRepository
import android.content.Context

class FormularioViewModel : ViewModel() {
    var respuestas = mutableStateOf(FormularioRespuestas())
    private lateinit var routines: RoutineResponse
    private val rutinaRepository = RutinaRepository()

    init {
        // Cargar rutinas desde el JSON al inicializar el ViewModel
        loadRoutines(context) // Asegúrate de pasar un contexto válido
    }

    fun loadRoutines(context: Context) {
        routines = rutinaRepository.obtenerRutinasDesdeJson(context) // Carga las rutinas desde el JSON
    }

    fun obtenerRutinaDesdeBD(): RoutineDetail? {
        val r = respuestas.value
        return when {
            r.objetivo == "hipertrofia" && r.nivel == "iniciacion" && r.peso != null && r.peso > 60 && r.altura != null && r.altura > 160 && r.cintura != null && r.cintura > 80 -> {
                routines.routines["3_days"] // Ejemplo para obtener rutinas de 3 días
            }
            // Agrega más condiciones según sea necesario
            else -> null
        }
    }
}