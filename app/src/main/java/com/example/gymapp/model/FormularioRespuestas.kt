package com.example.gymapp.model

data class FormularioRespuestas(
    val peso: Int? = null,
    val altura: Int? = null,
    val cintura: Int? = null,
    val nivel: String? = null,
    val problemaFisico: String? = null,
    val diasEntreno: Int? = null,
    val objetivo: String? = null
) {
    fun esCompleto(): Boolean {
        return peso != null && altura != null && cintura != null &&
                nivel != null && problemaFisico != null &&
                diasEntreno != null && objetivo != null
    }
}
