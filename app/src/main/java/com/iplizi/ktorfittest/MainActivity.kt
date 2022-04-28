package com.iplizi.ktorfittest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.iplizi.ktorfittest.databinding.ActivityMainBinding
import com.iplizi.ktorfittest.model.api.ApiService
import com.iplizi.ktorfittest.model.data.ApiResponse
import com.iplizi.ktorfittest.model.di.AppModule.ktorfit
import de.jensklingenberg.ktorfit.create
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val api = ktorfit.create<ApiService>()
    val peopleState = MutableStateFlow(ApiResponse())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


     binding.button.setOnClickListener {
         fetchData()
     }
        
    }

    private fun fetchData() {

        lifecycleScope.launch {
            peopleState.value = api.getData()
        }

        lifecycleScope.launchWhenStarted {
            peopleState.collect { response ->
                binding.imageView.load(response.message) {
                    placeholder(R.drawable.ic_baseline_error_24)
                }
            }
        }
    }
}