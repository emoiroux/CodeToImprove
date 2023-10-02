package com.example.codetoimprove.data

import java.util.*

class myDataSource : BaseDataSource<String> {

    override fun fetchData(): String? {
        return simulateNetworkCall()
    }

    // This method simulate a network request
    private fun simulateNetworkCall(): String? {
        val random = Random()
        return if (random.nextBoolean()) {
            "Hello, world! ${Random().nextInt(99)}"
        } else {
            "Hello, world!"
        }
    }
}
