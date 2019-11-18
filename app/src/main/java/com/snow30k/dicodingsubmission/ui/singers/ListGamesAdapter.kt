package com.snow30k.dicodingsubmission.ui.singers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.snow30k.dicodingsubmission.R
import com.snow30k.dicodingsubmission.data.Game
import kotlinx.android.synthetic.main.games_item.view.*

class ListGamesAdapter(private val listGames: List<Game>): RecyclerView.Adapter<ListGamesAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Game)
    }

    fun setItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.games_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGames.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val game = listGames[position]

        Glide.with(holder.itemView.context).load(game.img).apply(RequestOptions().override(70, 70)).into(holder.gameImg)
        holder.tvGameName.text = game.name
        holder.tvGameGenre.text = game.genre
        holder.tvGameAuthor.text = game.author

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGames[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvGameName = itemView.tv_game_name
        var tvGameGenre = itemView.tv_game_genre
        var tvGameAuthor = itemView.tv_game_author
        var gameImg = itemView.img_game
    }
}