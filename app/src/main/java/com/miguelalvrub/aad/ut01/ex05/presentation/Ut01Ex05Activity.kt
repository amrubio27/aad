package com.miguelalvrub.aad.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex05.data.UserRepository
import com.miguelalvrub.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.miguelalvrub.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex05)

        init()
    }

    private fun init(){
        //Obtain all users from data layer
        val userRepository = UserRepository(
            UsersLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            UsersRemoteDataSource()
        )

        /*
        val users = userRepository.getUsers()
        Log.d("@dev","Users: $users")

         */
    }
}