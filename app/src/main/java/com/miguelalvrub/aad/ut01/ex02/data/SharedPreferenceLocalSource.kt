package com.miguelalvrub.aad.ut01.ex02.data

import android.content.Context
import com.miguelalvrub.aad.R
import com.miguelalvrub.aad.ut01.ex01.presentation.Ut01Ex01Activity
import com.miguelalvrub.aad.ut01.ex01.domain.Customer
import com.miguelalvrub.aad.ut01.ex02.domain.WasOpened
import com.miguelalvrub.aad.ut01.ex02.presentation.ut01ex02Activity

class SharedPreferenceLocalSource (val activity: ut01ex02Activity){
    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE
    )

    fun saveOpened(wasOpened: WasOpened){
        val editor = sharedPref.edit()

        editor.apply{

            putBoolean("Opened", wasOpened.Opened)
            apply()
        }
    }

    fun getOpened(): WasOpened {
        return WasOpened(
            sharedPref.getBoolean("Opened", true)
            )
    }
}