package com.example.aacbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyRepositoryImpl(counter: Int) : MyRepository {

    // 이 부분은 실제로는 room이나 retrofit에서 받아오게 됨
    private val liveCounter = MutableLiveData<Int>(counter)

    override fun getCounter() : LiveData<Int> {
        return liveCounter
    }

    override fun increaseCounter() {
        liveCounter.value = liveCounter.value?.plus(1)
    }
}