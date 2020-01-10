package net.ombre_jin.td2

import android.content.Context
import android.preference.PreferenceManager
import com.squareup.moshi.Moshi
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class API(val context: Context) {

    companion object {
        private const val BASE_URL = "https://android-tasks-api.herokuapp.com/api/"
        //private const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo3MCwiZXhwIjoxNjA4Mzg0NDk2fQ.0cJr9k_b6W3xHd0Dyh8q43yxVL7wdv77x9sLuIVfRFE"
        lateinit var INSTANCE: API
    }
    fun getToken(): String?{
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SHARED_PREF_TOKEN_KEY,null)
    }

    private val moshi = Moshi.Builder().build()

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer" + getToken())
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

