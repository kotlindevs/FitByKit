package com.example.fitbykit.Repository

class WorkoutRepository {
    fun getWorkoutDetails(workout: String): List<Pair<String, String>> {
        return when (workout) {
            "Chest" -> listOf(
                "1. Bench Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=gRVjAtPip0Y",
                "2. Incline Dumbbell Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=8iPEnn-ltC8",
                "3. Cable Flyes - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=JJ707zVPigw",
                "4. Dumbbell Flyes - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=eozdVDA78K0",
                "5. Chest Press Machine - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=sDJF_NmTJbc",
                "6. Push-Ups - 4 sets of 15-20 reps" to "https://www.youtube.com/watch?v=_l3ySVKYVJ8",
                "7. Decline Bench Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=IqyxPqxPzXk",
                "8. Pec Deck Machine - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=Iwe6AmxVf7o",
                "9. Close-Grip Bench Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=nrKfAItuf44",
                "10. Incline Bench Cable Flyes - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=FT1kDcotjAg"
            )

            "Shoulders" -> listOf(
                "1. Incline Press Machine - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=vAgiTr5nAGc",
                "2. Overhead Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=B-aVuyhvLHU",
                "3. Lateral Raises - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=kDqklk1ZESo",
                "4. Front Raises - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=-t7fuZ0KhDA",
                "5. Arnold Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=6Z15_WdXmVw",
                "6. Rear Delt Flyes - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=LsNEoBlhUYA",
                "7. Face Pulls - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=rep-qVOkqgk",
                "8. Dumbbell Shrugs - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=pgodt2plKBk",
                "9. Cable Lateral Raises - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=NJeo8fsI8k0",
                "10. Seated Dumbbell Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=B-aVuyhvLHU"
            )

            "Triceps" -> listOf(
                "1. Tricep Dips - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=2z8JmcrW-As",
                "2. Tricep Pushdowns - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=2-LAMcpzODU",
                "3. Overhead Tricep Extension - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=6SS6K3lAwZ8",
                "4. Close-Grip Bench Press - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=nrKfAItuf44",
                "5. Skull Crushers - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=d_KZxkY_0cM",
                "6. Dumbbell Kickbacks - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=6SS6K3lAwZ8",
                "7. Bench Dips - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=sWjTnBmCHTY",
                "8. Rope Pushdowns - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=KT0H4ImJAV8",
                "9. One-Arm Overhead Extension - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=_gsUck-7M74",
                "10. Reverse Grip Tricep Pushdown - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=RAVQ4iu4H6I"
            )

            "Back" -> listOf(
                "1. Lat Pull Down - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=lueEJGjTuPQ",
                "2. Seated Row Machine - 3 sets of 8-12 reps" to "https://www.youtube.com/watch?v=GZbfZ033f74",
                "3. T-bar Row Machine - 3 sets of 8-12 reps" to "https://www.youtube.com/watch?v=A_aXdGfj6MI",
                "4. Rear Delt Fly Machine - 3 sets of 8-12 reps" to "https://www.youtube.com/watch?v=fyC1wBszywE",
                "5. Dumbbell Shrugs - 3 sets of 8-12 reps" to "https://www.youtube.com/watch?v=xWvEtxRcs1I",
                "6. Bent Over Rows - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=asrwlIxLeko",
                "7. Deadlifts - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=ytGaGIn3SjE",
                "8. Pull-Ups - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=eGo4IYlbE5g",
                "9. Single-Arm Dumbbell Row - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=-koP10y1qZI",
                "10. Face Pulls - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=rep-qVOkqgk"
            )

            "Biceps" -> listOf(
                "1. Barbell Curls - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=LY1V6UbRHFM",
                "2. Hammer Curls - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=zC3nLlEvin4",
                "3. Concentration Curls - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=VPYZRkVJQUY",
                "4. Preacher Curls - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=gghZ8Mn1O5U",
                "5. Cable Curls - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=t-2dqEe3zFc",
                "6. Spider Curls - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=eoVbQeBy2q8",
                "7. Incline Dumbbell Curls - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=soxrZlIl35U",
                "8. Zottman Curls - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=-pEcJGK8bCA",
                "9. Reverse Curls - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=BP35p6W5WA4",
                "10. Standing Bicep Cable Curl - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=-2XH6FO4-U0"
            )

            "Legs" -> listOf(
                "1. Squats - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=Dy28eq2PjcM",
                "2. Leg Press - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=IZxyjW7MPJQ",
                "3. Leg Curls - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=1Tq3QdYUuHs",
                "4. Leg Extensions - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=yRkUDZNyjfc",
                "5. Calf Raises - 4 sets of 15-20 reps" to "https://www.youtube.com/watch?v=gwLzBJYoWlI",
                "6. Lunges - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=QOVaHwm-Q6U",
                "7. Romanian Deadlifts - 4 sets of 8-12 reps" to "https://www.youtube.com/watch?v=2SHsk9AzdjA",
                "8. Bulgarian Split Squats - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=KU3psaOTGmc",
                "9. Glute Bridges - 4 sets of 12-15 reps" to "https://www.youtube.com/watch?v=9Q6Dbc_JM6k",
                "10. Box Jumps - 3 sets of 12-15 reps" to "https://www.youtube.com/watch?v=52rEsX6O0Sc"
            )

            else -> emptyList()
        }
    }
}

