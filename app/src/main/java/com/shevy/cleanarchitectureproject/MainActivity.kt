package com.shevy.cleanarchitectureproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shevy.cleanarchitectureproject.databinding.ActivityMainBinding
import java.util.Observer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //private val vm by viewModel<MainViewModel>()

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
            //vm.save(text)
        }

        receiveButton.setOnClickListener {
            //vm.load()
        }
    }
}