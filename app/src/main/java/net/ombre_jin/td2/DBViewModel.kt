package net.ombre_jin.td2

import layout.Association

object DBViewModel {
    public val associations = mutableListOf(
        Association(id = 0, gender = "movie", word1 = "trash", word2 = "sugar", description = "description 1"),
        Association(id = 1, gender = "theater", word1 = "school", word2 = "rock", description = "22"),
        Association(id = 2, gender = "BD", word1 = "trash", word2 = "sugar", description = "descrip 333")
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