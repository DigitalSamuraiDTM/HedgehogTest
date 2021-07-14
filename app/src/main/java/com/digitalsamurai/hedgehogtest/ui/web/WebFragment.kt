package com.digitalsamurai.hedgehogtest.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.digitalsamurai.hedgehogtest.ApplicationM
import com.digitalsamurai.hedgehogtest.R
import com.digitalsamurai.hedgehogtest.ui.jokes.PresenterJokesFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class WebFragment : MvpAppCompatFragment() , InterfaceWeb {

    private lateinit var webView : WebView

    @Inject
    lateinit var presenterProvider : Provider<PresenterWebFragment>
    val presenter by moxyPresenter {presenterProvider.get()};

    //в onCreate производим инъекцию и насыщаем поля
    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationM.getAppComponent().injectPresenterWeb(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webView = view.findViewById(R.id.fr_web_webview)
        super.onViewCreated(view, savedInstanceState)
    }

    //на паузу надо запомнить наше место
    override fun onPause() {
        presenter.saveState(webView)
        super.onPause()
    }

    //инициализация в onResume потому что только тогда презентер привязывается к фрагменту
    override fun onResume() {
        presenter.initializeWebView(webView);
        super.onResume()
    }

    //функция, которая вызывается когда нажимаем back (call из активити)
    fun goBackWebView(){
        if (webView.canGoBack()){
            webView.goBack()
        }
    }

}