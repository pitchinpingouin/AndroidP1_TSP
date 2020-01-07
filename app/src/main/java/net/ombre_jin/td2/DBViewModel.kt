package net.ombre_jin.td2

import layout.Association

object DBViewModel {
    public val associations = mutableListOf(
        Association(id = 0, gender = "Movie", word1 = "Trash", word2 = "Sugar", description = "description 1"),
        Association(id = 1, gender = "Theater", word1 = "Death", word2 = "Light", description = "description 2"),
        Association(id = 2, gender = "Advertising", word1 = "Whiteboard", word2 = "Cell", description = "description 3"),
        Association(id = 3, gender = "BD & Comics", word1 = "Harmony", word2 = "Ants", description = "description 4"),
        Association(id = 4, gender = "Video Game", word1 = "Cube", word2 = "Hazard", description = "description 5"),
        Association(id = 5, gender = "Sport", word1 = "Writings", word2 = "Ball", description = "description 6"),
        Association(id = 6, gender = "Product", word1 = "Despair", word2 = "Computer", description = "description 7"),
        Association(id = 7, gender = "Music", word1 = "Circle", word2 = "Sales", description = "description 8"),
        Association(id = 8, gender = "Poem", word1 = "Battlefield", word2 = "Ice Cream", description = "description 9"),
        Association(id = 8, gender = "Video Game", word1 = "Annihilator", word2 = "Utopia", description = "description 10"),
        Association(id = 9, gender = "Sculpture & Art", word1 = "Zoo", word2 = "Sky", description = "description 11"),
        Association(id = 10, gender = "App", word1 = "Germany", word2 = "Puzzles", description = "description 12"),
        Association(id = 11, gender = "Tale", word1 = "Keyboard", word2 = "Vampires", description = "description 13"),
        Association(id = 12, gender = "TV Show", word1 = "Tacos", word2 = "Bell", description = "description 14"),
        Association(id = 13, gender = "Novel", word1 = "Saber", word2 = "Life", description = "description 15")
    )

    public val genders = mutableListOf(
        "Movie",
        "Theater",
        "Advertising",
        "BD & Comics",
        "Video Game",
        "Board Game",
        "Sport",
        "Product",
        "Music",
        "Novel",
        "Poem",
        "Sculpture & Art",
        "TV Show",
        "App",
        "Tale"
    )
}