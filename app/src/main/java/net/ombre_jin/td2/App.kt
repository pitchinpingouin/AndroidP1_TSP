package net.ombre_jin.td2

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        API.INSTANCE = API(this)
    }
}