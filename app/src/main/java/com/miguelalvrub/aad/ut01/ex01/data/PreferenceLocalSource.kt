package com.miguelalvrub.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.miguelalvrub.aad.ut01.ex01.domain.Customer

class PreferenceLocalSource (private val  activity: Activity){
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )

    fun getCustomer(): Customer {
        return Customer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname","no existe")!!,
            sharedPref.getBoolean("isActive", true)
        )
    }

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("isActive", customer.isActive)
            apply()
        }

    }

}