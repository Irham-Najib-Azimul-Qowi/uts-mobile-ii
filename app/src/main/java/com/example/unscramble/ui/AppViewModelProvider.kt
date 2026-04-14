package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.unscramble.UnscrambleApplication

/**
 * Factory to provide the [WordRepository] to the [GameViewModel].
 */
object AppViewModelProvider {
    val Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            // Get the application object from extras
            val application = checkNotNull(extras[APPLICATION_KEY]) as UnscrambleApplication
            
            return GameViewModel(application.repository) as T
        }
    }
}
