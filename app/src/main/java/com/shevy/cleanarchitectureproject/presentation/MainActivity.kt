package com.shevy.cleanarchitectureproject.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shevy.cleanarchitectureproject.data.repository.UserRepositoryImpl
import com.shevy.cleanarchitectureproject.databinding.ActivityMainBinding
import com.shevy.cleanarchitectureproject.domain.models.SaveUserNameParam
import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.usecase.GetUserNameUseCase
import com.shevy.cleanarchitectureproject.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //private val vm by viewModel<MainViewModel>()

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("AAA", "Activity created")

        val dataTextView = binding.dataTextView
        val dataEditView = binding.dataEditText
        val saveButton = binding.saveButton
        val receiveButton = binding.receiveButton

/*        vm.resultLive.observe(this, Observer { text ->
            dataTextView.text = text
        })*/

        saveButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val param = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param)
            dataTextView.text = "Save result = $result"
            //vm.save(text)
        }

        receiveButton.setOnClickListener {

            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
            //vm.load()
        }
    }
}