package com.shevy.cleanarchitectureproject.di

import com.shevy.cleanarchitectureproject.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }
}