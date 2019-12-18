package net.ombre_jin.td2


import layout.Task
import retrofit2.Response
import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(): Response<List<Task>>
}
