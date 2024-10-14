package com.example.fitbykit.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class DietListViewModel : ViewModel() {
    private val _dietGroup = mutableStateListOf(

        "Monday" to
                "\nBreakfast \n \nstart with 2 whole wheat bread slices with peanut butter, a glass of almond milk, and a banana for breakfast. \n" +
                "\nCollege Break \n \nDuring your college break, have a bowl of sprouts salad with cucumber, tomato, and lime. \n" +
                "\nLunch \n \nFor lunch, enjoy 2 bajra or jowar rotis with mixed vegetable sabzi (spinach, carrot, beans) and a small bowl of curd. \n" +
                "\nPre-workout \n \nhave an apple and 10 almonds \n" +
                "\nPost-workout \n \ndrink a smoothie made of spinach, banana, and yogurt. \n" +
                "\nDinner \n \nFor dinner, eat a bowl of lentil dal with 1 roti and a mixed salad.",

        "Tuesday" to
                "\nBreakfast \n \nhave oats porridge with almonds, flaxseeds, and honey for breakfast. \n " +
                "\nCollege Break \n \nDuring your college break, eat a boiled sweet potato with lime and salt. \n " +
                "\nLunch \n \nFor lunch, have 2 ragi rotis with vegetable sabzi (cauliflower, peas, bell peppers) and a bowl of dal. \n" +
                "\nPre-workout \n \neat a banana and some walnuts. \n" +
                "\nPost-workout \n \nhave a boiled egg (or tofu) with cucumber slices and hummus. \n" +
                "\nDinner \n \nFor dinner, eat paneer (or tofu) bhurji with brown rice and sautéed vegetables.",

        "Wednesday" to
                "\nBreakfast \n \nstart with poha made with peanuts, curry leaves, and vegetables (carrot, peas, onion) for breakfast. \n" +
                "\nCollege Break \n \nDuring your college break, have a fruit of your choice, like an apple or orange, with a few almonds. \n" +
                "\nLunch \n \nFor lunch, eat 2 jowar rotis, mixed beans curry (rajma or chickpea), and cucumber salad. \n" +
                "\nPre-workout \n \ndrink lemon water and snack on a handful of peanuts. \n" +
                "\nPost-workout \n \nenjoy a glass of buttermilk with chia seeds. \n" +
                "\nDinner \n \nFor dinner, stir-fry vegetables with tofu and have a bowl of brown rice.",

        "Thursday" to
                "\nBreakfast \n \nhave upma with vegetables (carrot, beans) and a handful of peanuts for breakfast. \n" +
                "\nCollege Break \n \nDuring your college break, eat a fruit like papaya and a few walnuts. \n" +
                "\nLunch \n \nFor lunch, eat 2 bajra rotis with dal tadka and a green leafy vegetable sabzi like spinach. \n" +
                "\nPre-workout \n \neat a banana with peanut butter. \n" +
                "\nPost-workout \n \nhave a smoothie made of spinach, cucumber, and yogurt. \n" +
                "\nDinner \n \nFor dinner, enjoy paneer curry with 1 roti and a vegetable salad.",

        "Friday" to
                "\nBreakfast \n \nstart your day with vegetable and paneer stuffed paratha with curd. \n" +
                "\nCollege Break \n \nDuring your college break, eat a fruit like an orange or pear and 10 cashews. \n" +
                "\nLunch \n \nFor lunch, eat 2 jowar rotis with mixed vegetables (carrot, bell pepper, and beans) and curd. \n" +
                "\nPre-workout \n \nhave a boiled egg (or tofu) with carrot sticks. \n" +
                "\nPost-workout \n \ndrink coconut water and eat a small fruit like kiwi or pear. \n" +
                "\nDinner \n \nFor dinner, have a bowl of chickpea curry with a portion of quinoa.",

        "Saturday" to
                "\nBreakfast \n \nhave a smoothie bowl made of banana, oats, almond milk, and chia seeds for breakfast. \n" +
                "\nCollege Break \n \nDuring your college break, snack on roasted chickpeas. \n" +
                "\nLunch \n \nFor lunch, eat 2 roti with dal makhani and vegetable sabzi like okra or brinjal. \n" +
                "\nPre-workout \n \neat an apple with walnuts. \n" +
                "\nPost-workout \n \ndrink buttermilk with chia seeds.\n" +
                "\nDinner \n \nFor dinner, enjoy paneer tikka with a mixed salad and 1 roti.",

        "Sunday" to
                "\nBreakfast \n \nstart with whole wheat pancakes topped with honey and berries. \n" +
                "\nLunch \n \nFor lunch, eat 2 roti with chole (chickpea curry) and cucumber-tomato salad. \n" +
                "\nDinner \n \nFor dinner, enjoy spinach and paneer curry with 1 roti."
    )

    val dietGroups : SnapshotStateList<Pair<String,String>>
        get() = _dietGroup
}