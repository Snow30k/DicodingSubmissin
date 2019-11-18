package com.snow30k.dicodingsubmission.ui.singers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.snow30k.dicodingsubmission.R
import com.snow30k.dicodingsubmission.data.Game
import com.snow30k.dicodingsubmission.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_detail_game.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailGameActivity : AppCompatActivity() {

    companion object {
        const val GAME_ID = "game_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_game)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Game Details"
        }

        val gameId = intent.getIntExtra(GAME_ID, -1)
        initUi(gameId)
    }

    private fun initUi(idx: Int) {
        val factory = InjectorUtils.provideGamseVMF()
        val viewModel = ViewModelProviders.of(this, factory).get(GamesVM::class.java)

        viewModel.getGames().observe(this, Observer { games ->

            val game: Game = games[idx]
            tv_dGame_name.text = game.name
            tv_dGame_genre.text = game.genre
            tv_dGame_author.text = game.author
            tv_os.text = game.os
            tv_processor.text = game.processor
            tv_graphics.text = game.vga
            tv_memory.text = game.ram
            tv_storage.text = game.storage
            tv_desc.text = game.desc
            d_game_img.setImageResource(game.img)
        })
    }
}
