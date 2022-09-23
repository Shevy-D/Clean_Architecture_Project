package com.shevy.cleanarchitectureproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.usecase.GetUserNameUseCase
import com.shevy.cleanarchitectureproject.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    fun save(text: String) {
        val param = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}