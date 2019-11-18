package com.snow30k.dicodingsubmission.ui.singers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.snow30k.dicodingsubmission.R
import com.snow30k.dicodingsubmission.data.Game
import com.snow30k.dicodingsubmission.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Top 10 Games Spec"
        }
        initUi()
    }

    private fun initUi() {
        val factory = InjectorUtils.provideGamseVMF()
        val viewModel = ViewModelProviders.of(this, factory).get(GamesVM::class.java)

        viewModel.getGames().observe(this, Observer { games ->
            rv_games.setHasFixedSize(true)
            rv_games.layoutManager = LinearLayoutManager(this)
            val listGamesAdapter = ListGamesAdapter(games)
            rv_games.adapter  = listGamesAdapter

            listGamesAdapter.setItemClickCallback(object : ListGamesAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Game) {
                    showSelectedHero(data)
                }
            })
        })
    }

    private fun showSelectedHero(game: Game) {
        val detailGameActivity = Intent(this@MainActivity, DetailGameActivity::class.java)
        detailGameActivity.putExtra(DetailGameActivity.GAME_ID, game.id)
        startActivity(detailGameActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.mProfil -> {
                val profil = Intent(this@MainActivity, ProfilActivity::class.java)
                startActivity(profil)
            }
        }
    }
}
