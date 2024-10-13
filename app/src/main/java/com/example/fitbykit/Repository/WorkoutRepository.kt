package com.example.fitbykit.Repository

class WorkoutRepository {
    fun getWorkoutDetails(workout: String): List<Pair<String, String>> {
        return when (workout) {
            "Chest" -> listOf(
                "1. Bench Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/benchpress.mp4",
                "2. Incline Dumbbell Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/incline.mp4",
                "3. Cable Flyes - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/cableflyes.mp4",
                "4. Dumbbell Flyes - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/dumbellflyes.mp4",
                "5. Chest Press Machine - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/chestpressmachine.mp4",
                "6. Push-Ups - 4 sets of 15-20 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/pushups.mp4",
                "7. Decline Bench Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/declinebenchpress.mp4",
                "8. Pec Deck Machine - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/pecdecfly.mp4"
            )

            "Shoulders" -> listOf(
                "1. Incline Press Machine - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/shoulders/inclinepress.mp4",
                "2. Overhead Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/shoulders/overhead.mp4",
                "3. Lateral Raises - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/shoulders/lateral.mp4",
                "4. Front Raises - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/shoulders/front.mp4",
                "5. Arnold Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/shoulders/arnold.mp4",
            )

            "Triceps" -> listOf(
                "1. Tricep Dips - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/dips.mp4",
                "2. Tricep Pushdowns - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/pushdowns.mp4",
                "3. Overhead Tricep Extension - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/extension.mp4",
                "4. Close-Grip Bench Press - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/closegrip.mp4",
                "5. Skull Crushers - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/skullcrushers.mp4",
                "6. Dumbbell Kickbacks - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/triceps/kickbck.mp4",
            )

            "Back" -> listOf(
                "1. Lat Pull Down - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/latpulldown.mp4",
                "2. Seated Row Machine - 3 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/seatedrow.mp4",
                "3. T-bar Row Machine - 3 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/tbarrow.mp4",
                "4. Rear Delt Fly Machine - 3 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/reardelt.mp4",
                "5. Dumbbell Shrugs - 3 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/shrugs.mp4",
                "6. Bent Over Rows - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/bentoverrows.mp4",
                "7. Deadlifts - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/deadlift.mp4",
                "8. Pull-Ups - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/back/pullups.mp4",
            )

            "Biceps" -> listOf(
                "1. Barbell Curls - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/barbellcurls.mp4",
                "2. Hammer Curls - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/hamer.mp4",
                "3. Concentration Curls - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/concen.mp4",
                "4. Preacher Curls - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/preacher.mp4",
                "5. Cable Curls - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/cable.mp4",
                "6. Spider Curls - 3 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/biceps/spider.mp4",
            )

            "Legs" -> listOf(
                "1. Squats - 4 sets of 8-12 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/legs/squats.mp4",
                "2. Leg Press - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/legs/legpress.mp4",
                "3. Leg Curls - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/legs/curls.mp4",
                "4. Leg Extensions - 4 sets of 12-15 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/legs/extension.mp4",
                "5. Calf Raises - 4 sets of 15-20 reps" to "https://github.com/Admin-573/fitbykitvids/raw/refs/heads/main/legs/calf.mp4",
            )

            else -> emptyList()
        }
    }
}

