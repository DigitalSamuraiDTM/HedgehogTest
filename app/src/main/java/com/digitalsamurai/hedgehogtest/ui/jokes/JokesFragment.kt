package com.digitalsamurai.hedgehogtest.ui.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.digitalsamurai.hedgehogtest.ApplicationM
import com.digitalsamurai.hedgehogtest.R
import moxy.MvpAppCompatFragment
import javax.inject.Inject
import javax.inject.Provider
import moxy.ktx.moxyPresenter

class JokesFragment : MvpAppCompatFragment(), InterfaceJokes {

    private lateinit var editCount : EditText
    private lateinit var buttonReload : Button
    private lateinit var recyclerJokes : RecyclerView
    private lateinit var layoutData : ConstraintLayout
    private lateinit var layoutLoading : ConstraintLayout

    @Inject
    lateinit var presenterProvider : Provider<PresenterJokesFragment>

    val presenter by moxyPresenter {presenterProvider.get()};

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationM.getAppComponent().injectPresenterJokes(this)
        super.onCreate(savedInstanceState)
    }
    //инициализация адаптера в onResume потому что только тогда презентер аттачед к фрагменту
    override fun onResume() {
        presenter.initializeAdapter(requireActivity().applicationContext, recyclerJokes)
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokes, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editCount = view.findViewById(R.id.fr_jokes_edit_countJokes)
        buttonReload = view.findViewById(R.id.fr_jokes_button_reloadJokes)
        buttonReload.setOnClickListener({
            presenter.reloadJokes(editCount.text.toString().toInt());
        })
        recyclerJokes = view.findViewById(R.id.fr_jokes_recycler_jokes)

        layoutData  = view.findViewById(R.id.fr_jokes_lay_data)
        layoutLoading = view.findViewById(R.id.fr_jokes_lay_loading)
        super.onViewCreated(view, savedInstanceState)
    }


    override fun showLoading(){
        layoutData.visibility = View.GONE
        layoutLoading.visibility = View.VISIBLE
    }

    override fun showData() {
        layoutData.visibility = View.VISIBLE
        layoutLoading.visibility = View.GONE
    }
    //ошибка, если не будет интернета или запрос не будет успешен
    override fun showError(error : Int) {
        layoutData.visibility = View.GONE
        layoutLoading.visibility = View.VISIBLE
        when(error){
            0 ->{
                Toast.makeText(requireContext(),"Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}