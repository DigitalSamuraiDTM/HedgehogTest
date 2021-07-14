package com.digitalsamurai.hedgehogtest.dagger2

import com.digitalsamurai.hedgehogtest.ui.jokes.JokesFragment
import com.digitalsamurai.hedgehogtest.ui.web.WebFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {
    fun injectPresenterJokes(FragmentJokes : JokesFragment)
    fun injectPresenterWeb(fragmentWeb : WebFragment)
}