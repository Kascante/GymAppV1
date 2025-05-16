import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import com.example.gymapp.viewmodel.FormularioViewModel

@Composable
fun PantallaRutina(viewModel: FormularioViewModel) {
    val rutina = viewModel.obtenerRutinaDesdeBD()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Rutina Seleccionada:")
        rutina?.let {
            Text(text = it.nombre)
            it.ejercicios.forEach { ejercicio ->
                Text(text = "${'$'}{ejercicio.nombre}: ${'$'}{ejercicio.descripcion}")
            }
        } ?: run {
            Text(text = "No se ha seleccionado ninguna rutina.")
        }
        Button(onClick = { viewModel.obtenerRutinaDesdeBD() }) {
            Text("Obtener Rutina")
        }
    }
}
