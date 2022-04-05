package com.example.aacbasic

import androidx.lifecycle.*

class MyViewModel(
    _counter : Int,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

//    var counter: Int = _counter
    var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

    val liveCounter : MutableLiveData<Int> = MutableLiveData(_counter)
    val modifiedCounter : LiveData<String> = Transformations.map(liveCounter) { counter ->
        "$counter 입니다"
    }

    val hasChecked : MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}