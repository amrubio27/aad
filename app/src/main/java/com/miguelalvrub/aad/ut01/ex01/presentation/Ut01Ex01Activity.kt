package com.miguelalvrub.aad.ut01.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex01.data.PreferenceLocalSource
import com.miguelalvrub.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.miguelalvrub.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreference()
    }

    private fun initSharedPreference(){
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spCustomer = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1", "Surname1", true))


        ContextCompat.getColor(this, R.color.black)


        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer" )
    }

    private fun initPreference(){
        //val spCustomer: PreferenceLocalSource = PreferenceLocalSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1", "Surname1", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer" )
    }

}