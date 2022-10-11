package com.miguelalvrub.aad.ut01.ex02.data

import android.app.Activity
import android.content.Context
import com.miguelalvrub.aad.ut01.ex01.domain.Customer
import com.miguelalvrub.aad.ut01.ex02.domain.WasOpened

class PreferenceLocalSource (private val  activity: Activity){
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )

    fun getOpened(): WasOpened {
        return WasOpened(
            sharedPref.getBoolean("Opened", true)
        )
    }

    fun saveOpened(wasOpened: WasOpened){
        val editor = sharedPref.edit()
        editor.apply{
            putBoolean("Opened", wasOpened.Opened)
            apply()
        }
    }
}