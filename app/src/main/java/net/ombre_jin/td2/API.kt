package net.ombre_jin.td2

import android.R.string
import android.os.AsyncTask.execute
import kotlinx.io.IOException
import okhttp3.*


object API {
    const val BASE_URL = "http://api.wordnik.com/v4/words.json/"
    const val BASE_URL_TEST = "http://api.wordnik.com/v4/words.json/randomWord?hasDictionaryDef=true&includePartOfSpeech=noun&maxLength=9&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"
    const val BASE_URL_TEST2 = "https://api.wordnik.com/v4/words.json/randomWords?hasDictionaryDef=true&includePartOfSpeech=noun&maxCorpusCount=-1&minDictionaryCount=1&maxDictionaryCount=-1&minLength=4&maxLength=11&limit=2&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"
    const val URL_DEF = "/definitions?limit=1&includeRelated=false&sourceDictionaries=all&useCanonical=false&includeTags=false&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"



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