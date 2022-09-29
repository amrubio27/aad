package com.miguelalvrub.aad.ut01.ex01.data

import android.content.Context
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex01.domain.Customer
import com.miguelalvrub.aad.ut01.ex01.presentation.Ut01Ex01Activity

class SharedPreferenceLocalSource(val activity: Ut01Ex01Activity){
    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE
    )

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        //Java style
            /*editor.putInt("id", customer.id)
            editor.putString("name", customer.name)
            editor.putString("surname", customer.surname)
            editor.putBoolean("isActive", customer.isActive)
            editor.apply() */ //asincrono, no bloquea el hilo que usa el put
            //editor.commit() sincrono, utiliza el mismo hilo puede bloquear el hilo. puedes necesitar que se termine de escribir antes de aplicar

        //kotlin style
        editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("isActive", customer.isActive)
            apply()
        }

    }

    fun getCustomer(): Customer{
        return Customer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname","no existe")!!,
            sharedPref.getBoolean("isActive", true)
            )
    }
}