package com.example.gymapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gymapp.model.FormularioRespuestas

class FormularioViewModel : ViewModel() {
    var respuestas = mutableStateOf(FormularioRespuestas())

    fun actualizarRespuestas(nuevas: FormularioRespuestas) {
        respuestas.value = nuevas
    }

    fun obtenerRutinaDesdeBD(): String {
        val r = respuestas.value
        return when {
            r.objetivo == "hipertrofia" && r.nivel == "avanzado" -> "Rutina Push-Pull-Legs avanzada"
            r.objetivo == "pérdida de peso" && r.problemaFisico == "espalda" -> "Circuito funcional + movilidad"
            else -> "Rutina general de tonificación"
        }
    }
}

