package com.snow30k.dicodingsubmission.ui.singers

import androidx.lifecycle.ViewModel
import com.snow30k.dicodingsubmission.data.Game
import com.snow30k.dicodingsubmission.data.GameRepository

class GamesVM(private val gameRepository: GameRepository): ViewModel() {

    fun getGames() = gameRepository.getGames()

    fun  addGame(game: Game) = gameRepository.addGame(game)
}