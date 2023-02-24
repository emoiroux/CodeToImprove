package com.example.codetoimprove.data

import com.example.codetoimprove.MainActivity

class myRepository(private val mainActivity: MainActivity) {

    var refreshing: Boolean = false

    fun getData(): String? {
        mainActivity.logPerformingNetworkCall("myRepository", "fetching data from myDataSource")
        return myDataSource().fetchData()
    }

    fun refreshData(): String? {
        if (refreshing) {
            mainActivity.logNetworkCallFailure("myRepository", "network failure: already refreshing")
            return null
        }

        refreshing = true
        return getData()
    }

}