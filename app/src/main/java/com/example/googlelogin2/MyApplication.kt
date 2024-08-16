package com.example.googlelogin2

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MyApplication : Application() {
    companion object{
        lateinit var  auth: FirebaseAuth
        var email: String? = null
        fun checkAuth() : Boolean{
            var currentUser = auth.currentUser
            return currentUser?.let {
                email = currentUser.email
                currentUser.isEmailVerified
            } ?:let {
                false
            }
        }
    }
    override fun onCreate() {
    super.onCreate()
    auth = Firebase.auth
    }
}
