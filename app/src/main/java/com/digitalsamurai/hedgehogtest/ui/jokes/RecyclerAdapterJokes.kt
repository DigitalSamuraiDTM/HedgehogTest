package com.digitalsamurai.hedgehogtest.ui.jokes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalsamurai.hedgehogtest.R
import com.digitalsamurai.hedgehogtest.retrofit.Joke

class RecyclerAdapterJokes(private var data : ArrayList<Joke>, val context : Context) :
    RecyclerView.Adapter<RecyclerAdapterJokes.ViewHolderJokes>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderJokes {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_joke, parent, false)
        return ViewHolderJokes(view)
    }

    override fun onBindViewHolder(holder: ViewHolderJokes, position: Int) {
        holder.textViewJoke.setText(data.get(position).joke)
        holder.textViewId.setText((data.get(position).id).toString())
        holder.textViewCategories.setText(data.get(position).categories.joinToString())
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolderJokes(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var textViewJoke : TextView
         var textViewCategories : TextView
         var textViewId : TextView
        init {
            textViewJoke = itemView.findViewById(R.id.item_joke_view_joke)
            textViewCategories = itemView.findViewById(R.id.item_joke_view_categories)
            textViewId = itemView.findViewById(R.id.item_joke_view_id)
        }
    }
}