package com.snow30k.dicodingsubmission.data

class GameRepository private constructor(private val gameDao: GameDao){

    fun addGame(game: Game) {
        gameDao.addGame(game)
    }

    fun getGames() = gameDao.getGames()

    companion object {
        @Volatile private  var instance: GameRepository? = null
        fun getInstance(gameDao: GameDao) = instance ?: synchronized(this) {
            instance ?: GameRepository(gameDao).also { instance = it }
        }
    }
}