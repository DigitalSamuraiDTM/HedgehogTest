package com.digitalsamurai.hedgehogtest.ui.jokes

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.digitalsamurai.hedgehogtest.retrofit.API_ICNDB
import com.digitalsamurai.hedgehogtest.retrofit.DataJokes
import com.digitalsamurai.hedgehogtest.retrofit.Joke
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Response


class PresenterJokesFragment : MvpPresenter<InterfaceJokes>() {
    private lateinit var adapter : RecyclerAdapterJokes
    private var dataJokes : ArrayList<Joke> = ArrayList()

    fun initializeAdapter(context : Context, recycler : RecyclerView){
        adapter = RecyclerAdapterJokes(dataJokes,context)
        recycler.adapter = adapter
    }

    fun reloadJokes(count: Int) {
        viewState.showLoading()
        API_ICNDB.create().getRandomJokes(count).enqueue(object : retrofit2.Callback<DataJokes> {
            override fun onResponse(call: Call<DataJokes>, response: Response<DataJokes>) {
                dataJokes.clear()
                dataJokes.addAll((response.body() as DataJokes).value);
                adapter.notifyDataSetChanged()
                viewState.showData()
            }

            override fun onFailure(call: Call<DataJokes>, t: Throwable) {
                viewState.showError(0)
            }

        })
    }

}