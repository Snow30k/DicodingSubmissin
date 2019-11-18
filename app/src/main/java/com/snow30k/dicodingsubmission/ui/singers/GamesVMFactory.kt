package com.snow30k.dicodingsubmission.ui.singers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.snow30k.dicodingsubmission.data.GameRepository

class GamesVMFactory(private val gameRepository: GameRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GamesVM(gameRepository) as T
    }
}