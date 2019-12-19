package net.ombre_jin.td2

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object API {
    private const val BASE_URL = "https://android-tasks-api.herokuapp.com/api/"
    private const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo3MCwiZXhwIjoxNjA4Mzg0NDk2fQ.0cJr9k_b6W3xHd0Dyh8q43yxVL7wdv77x9sLuIVfRFE"

    private val moshi = Moshi.Builder().build()

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $TOKEN")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val userService: UserService by lazy { retrofit.create(UserService::class.java)}
    val taskService: TaskService by lazy { retrofit.create(TaskService::class.java)}
}

