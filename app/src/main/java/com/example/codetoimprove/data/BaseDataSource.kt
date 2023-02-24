package com.example.codetoimprove.data

interface BaseDataSource<T> {

    fun fetchData(): T?
}