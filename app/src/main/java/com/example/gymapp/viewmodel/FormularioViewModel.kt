package com.example.gymapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gymapp.model.FormularioRespuestas
import com.example.gymapp.model.RoutineResponse
import com.example.gymapp.repository.RutinaRepository
import android.content.Context

class FormularioViewModel(private val context: Context) : ViewModel() {
    var respuestas = mutableStateOf(FormularioRespuestas())
    private lateinit var routines: RoutineResponse
    private val rutinaRepository = RutinaRepository()

    init {
        loadRoutines(context) // Asegúrate de pasar un contexto válido
    }

    fun loadRoutines(context: Context) {
        routines = rutinaRepository.obtenerRutinasDesdeJson(context) // Carga las rutinas desde el JSON
        println("Rutinas cargadas: $routines") // Agregar log
    }

    fun obtenerRutinaDesdeBD(): RoutineDetail? {
        val r = respuestas.value
        println("Respuestas: $r") // Agregar log
        return when {
            r.objetivo == "hipertrofia" && r.nivel == "iniciacion" && r.peso != null && r.peso > 60 -> {
                routines.routines["3_days"] // Rutina para hipertrofia, iniciación
            }
            // Agrega más condiciones según sea necesario
            else -> null
        }
    }
}