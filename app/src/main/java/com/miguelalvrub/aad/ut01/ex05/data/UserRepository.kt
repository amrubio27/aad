package com.miguelalvrub.aad.ut01.ex05.data


import com.google.gson.Gson
import com.miguelalvrub.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.miguelalvrub.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.miguelalvrub.aad.ut01.ex05.domain.User

class UserRepository(
    private val localSource: UsersLocalDataSource,
    private val remoteSource: UsersRemoteDataSource) {

    private val gson = Gson()


    /**
     * First from local then from remote
     */

    fun getUsers(): List<User> {
        var users = localSource.getUsers()
        if (users == null){
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById(userId: Int) : User {
        var user = localSource.findById(userId)
        if(user==null){
            user = remoteSource.getUser(userId)
        }
        return user

    }

    fun removeUser(userId: Int){
        //sharedPref.edit().remove(userId.toString()).apply()
        localSource.remove(userId)
    }
}