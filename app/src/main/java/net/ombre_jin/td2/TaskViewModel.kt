package net.ombre_jin.td2

import layout.Task

object TaskViewModel {
    public val tasks = mutableListOf(
        Task(id = "1", title = "Task 1", description = "description 1"),
        Task(id = "2", title = "Task 2", description = "descr 2"),
        Task(id = "3", title = "Task 3", description = "Je suis une autre description")
    )
}