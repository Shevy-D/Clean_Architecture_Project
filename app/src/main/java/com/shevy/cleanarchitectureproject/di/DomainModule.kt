package com.shevy.cleanarchitectureproject.di

import com.shevy.cleanarchitectureproject.domain.usecase.GetUserNameUseCase
import com.shevy.cleanarchitectureproject.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}