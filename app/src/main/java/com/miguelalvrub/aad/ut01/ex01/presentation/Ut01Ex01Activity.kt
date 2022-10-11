package com.miguelalvrub.aad.ut01.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex01.data.PreferencesLocalSource
import com.miguelalvrub.aad.ut01.ex01.domain.Customer
class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)
        init()
        initAppConfig()
    }

    private fun init() {
        val localDataSource = PreferencesLocalSource(this)
        val testCustomer = Customer(1, "Name1", "Surname1", true)

        localDataSource.save(testCustomer)
        val customerSaved = localDataSource.getCustomer()
    }

    private fun initAppConfig() {

    }
}