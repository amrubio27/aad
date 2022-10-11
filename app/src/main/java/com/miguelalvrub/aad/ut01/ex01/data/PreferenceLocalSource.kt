package com.miguelalvrub.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.miguelalvrub.aad.ut01.ex01.domain.Customer

class PreferencesLocalSource(private val activity: Activity) {

    private val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)

    fun save(customer: Customer){
        val edit = sharedPref.edit()
        edit.putInt("id", customer.id)
        edit.putString("name", customer.name)
        edit.putString("surname", customer.surname)
        edit.putBoolean("is_active", customer.isActive)
        edit.apply() //guarda de forma asíncrona
        //edit.commit() guarda de forma síncrona

    }

    fun getCustomer() : Customer {
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", null) ?: "",
            sharedPref.getString("surname", "") ?: "",
            sharedPref.getBoolean("is_active", false)
        )
    }
}