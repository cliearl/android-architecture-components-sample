package com.example.aacbasic

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(
    _counter : Int,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

//    var counter: Int = _counter

    var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}