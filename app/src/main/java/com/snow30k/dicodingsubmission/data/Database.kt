package com.snow30k.dicodingsubmission.data

class Database private constructor(){

    var gameDao = GameDao()
        private set

    companion object {
        @Volatile private  var instance: Database? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: Database().also { instance = it }
        }
    }
}