package com.bangkit.navomobility.flow

import android.app.Application
import com.google.firebase.FirebaseApp

class RegisterFlowAppFlowApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}