package com.shevy.cleanarchitectureproject.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default last name"


class UserRepositoryImpl (private val context: Context) : UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }

}