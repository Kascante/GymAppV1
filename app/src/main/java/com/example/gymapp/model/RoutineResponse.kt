data class RoutineResponse(val routines: Map<String, RoutineDetail>)

data class RoutineDetail(
    val target: String,
    val workouts: List<Workout>,
    val cardio: Cardio? = null,
    val additional: String? = null
)

data class Workout(
    val day: Int,
    val exercises: List<Exercise>
)

data class Exercise(
    val name: String,
    val sets: Int,
    val reps: Int? = null,
    val duration: String? = null,
    val description: String? = null
)

data class Cardio(
    val day: Int,
    val description: String
)
