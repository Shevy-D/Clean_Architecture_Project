package com.shevy.cleanarchitectureproject.di

import com.shevy.cleanarchitectureproject.data.repository.UserRepositoryImpl
import com.shevy.cleanarchitectureproject.data.storage.UserStorage
import com.shevy.cleanarchitectureproject.data.storage.sharedprefs.SharedPrefUserStorage
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}