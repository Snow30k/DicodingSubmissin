package com.snow30k.dicodingsubmission.utilities

import com.snow30k.dicodingsubmission.data.Database
import com.snow30k.dicodingsubmission.data.GameRepository
import com.snow30k.dicodingsubmission.ui.singers.GamesVMFactory

object InjectorUtils {

    fun provideGamseVMF(): GamesVMFactory {
        val gameRepository = GameRepository.getInstance(Database.getInstance().gameDao)
        return GamesVMFactory(gameRepository)
    }
}