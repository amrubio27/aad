package com.miguelalvrub.aad.ut01.ex05.data.local


import android.content.SharedPreferences
import com.google.gson.Gson
import com.miguelalvrub.aad.ut01.ex05.domain.User


class UsersLocalDataSource(val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun saveUsers(users: List<User>){
        users.forEach{
            saveUser(it)
        }
    }

    private fun saveUser(user: User){
        //esto es como en el ejercicio de News

        val jsonUser = gson.toJson(user, User::class.java)
        //en el examen se pedira saber sacarlo de la ayuda de android

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser) //le paso la cadena de texto que contiene un usuario serializado
        edit.apply() //guarda de forma asíncrona para subir y actualizar los cambios
    }

    fun getUsers(): List<User>?{
        return listOf(
            User(
                sharedPref.getInt("id",0),
                sharedPref.getString("name",null) ?: "",
                sharedPref.getString("username","") ?: ""
            )
        )
    }

    /*
    fun getUsers(): List<User>{
        val users = mutableListOf<User>()
        sharedPref.all.forEach{ map ->
            users.add(gson.fromJson(map.value as String, User::class.java))

        }
    }
    */

    fun findById(userId: Int):User {
        val jsonUsers = sharedPref.getString(userId.toString(),"")
        return gson.fromJson(jsonUsers, User::class.java)

    }

    fun remove(userId: Int){
        sharedPref.edit().remove(userId.toString()).apply() //apply() al final o
        //edit.apply()
    }
}