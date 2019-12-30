package net.ombre_jin.td2


import layout.Word
import retrofit2.Response
import retrofit2.http.*

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(): Response<List<Word>>

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id: String): Response<String>

    @POST("tasks")
    suspend fun createTask(@Body task: Word): Response<Word>

    @PATCH("tasks/{id}")
    suspend fun updateTask(@Body task: Word): Response<Word>

}
