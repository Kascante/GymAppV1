import android.content.Context
import com.google.gson.Gson
import java.io.InputStreamReader

class RoutineRepository {
    fun obtenerRutinas(context: Context): RoutineResponse {
        val inputStream = context.assets.open("routines.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, RoutineResponse::class.java)
    }
}
