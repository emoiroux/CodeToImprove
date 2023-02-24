package com.example.codetoimprove

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.codetoimprove.data.myRepository
import com.example.codetoimprove.databinding.ActivityMainBinding
import com.example.codetoimprove.service.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repository = myRepository(this)

        viewModel.data.observe(this) {
            binding.contentMain.response.text = it
            fetchData()
        }

        viewModel = MyViewModel(repository)

        fetchData()

        binding.contentMain.btnRefresh.setOnClickListener {
            viewModel.refreshData()
        }
    }

    fun fetchData() {
        viewModel.FetchData()
    }

    fun logNetworkCallFailure(repositoryName: String, message: String) {
        Log.d(repositoryName, "network failure: $message")
    }

    fun logPerformingNetworkCall(repositoryName: String, message: String) {
        Log.d(repositoryName, "network call : $message")
    }
}

