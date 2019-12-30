package net.ombre_jin.td2

import layout.Word

object TaskViewModel {
    public val associations = mutableListOf(
        Word(id = 1, word = "Task 1", description = "description 1"),
        Word(id = 2, word = "Task 2", description = "descr 2"),
        Word(id = 3, word = "Task 3", description = "Je suis une autre description")
    )
}