package net.ombre_jin.td2

import android.R.string
import android.os.AsyncTask.execute
import kotlinx.io.IOException
import okhttp3.*


object API {
    private const val BASE_URL = "http://api.wordnik.com/v4/words.json/"
    const val BASE_URL_TEST = "http://api.wordnik.com/v4/words.json/randomWord?hasDictionaryDef=true&includePartOfSpeech=noun&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"
    const val BASE_URL_TEST2 = "https://api.letsbuildthatapp.com/youtube/home_feed"
    const val BASE_URL_TEST3 = "http://api.icndb.com/jokes/random/1http://api.icndb.com/jokes/random/"

    private const val TOKEN = "nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"

}
/*
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

*/