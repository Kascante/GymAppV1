package com.example.gymapp.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

@Composable
fun DropdownMenuString(opciones: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("Selecciona") }

    Column {
        Text(text = selected, modifier = Modifier.clickable { expanded = true })
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            opciones.forEach {
                DropdownMenuItem(onClick = {
                    selected = it
                    onSelect(it)
                    expanded = false
                }) { Text(it) }
            }
        }
    }
}
