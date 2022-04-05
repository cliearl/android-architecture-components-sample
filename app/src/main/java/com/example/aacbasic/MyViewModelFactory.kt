package com.example.aacbasic

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(
    private val counter: Int,
    private val repositoryImpl: MyRepositoryImpl,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle,
    ): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(counter, repositoryImpl, handle) as T
        }
        throw IllegalArgumentException("Viewmodel class not found")
    }
}

//class MyViewModelFactory(private val counter: Int) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
//            return MyViewModel(counter) as T
//        }
//        throw IllegalArgumentException("Viewmodel class not found")
//    }
//}

