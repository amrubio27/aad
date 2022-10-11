package com.miguelalvrub.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex02.data.SharedPreferenceLocalSource

class ut01ex02Activity : AppCompatActivity() {

    /*var isFirstOpened = false*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex2)

        initSharedPreference()
    }

    private fun initSharedPreference(){
        val spOpened = SharedPreferenceLocalSource(this)



        val newOpened = spOpened.getOpened()
        Log.d("@dev", "Customer $newOpened" )
    }
}