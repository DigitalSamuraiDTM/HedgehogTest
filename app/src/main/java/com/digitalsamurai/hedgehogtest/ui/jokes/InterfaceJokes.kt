package com.digitalsamurai.hedgehogtest.ui.jokes

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface InterfaceJokes : MvpView {
    @SingleState
    fun showLoading()
    @SingleState
    fun showData()
    @Skip
    fun showError(error : Int)

}