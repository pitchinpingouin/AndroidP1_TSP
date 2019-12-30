package net.ombre_jin.td2

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object API {
    private const val BASE_URL = "http://api.wordnik.com/v4/words.json/randomWord?api_key="
    private const val TOKEN = "nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"

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

    val taskService: TaskService by lazy { retrofit.create(TaskService::class.java)}
}

