package com.digitalsamurai.hedgehogtest.ui.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import moxy.MvpPresenter

class PresenterWebFragment : MvpPresenter<InterfaceWeb>() {
    private var bundle = Bundle()
    private var webClient = WebClient()


    @SuppressLint("SetJavaScriptEnabled")
    fun initializeWebView(webView: WebView) {
        //если изначально настроек не было у вебвью, то инициализируем, иначе восстанавливаем
        if (bundle.isEmpty){
            // включаем поддержку JavaScript
            webView.webViewClient = webClient
            webView.settings.javaScriptEnabled = true
            // указываем страницу загрузки
            webView.loadUrl("http://www.icndb.com/api/")
        } else{
            //так и не понял с чем это связано, но вебвьюклиент не сохраняется в бандле
            webView.webViewClient = webClient
            webView.restoreState(bundle)
        }
    }

    fun saveState(webView: WebView) {
        webView.saveState(bundle)
    }


}