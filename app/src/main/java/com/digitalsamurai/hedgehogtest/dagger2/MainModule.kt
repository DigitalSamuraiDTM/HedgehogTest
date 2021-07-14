package com.digitalsamurai.hedgehogtest.dagger2

import androidx.annotation.NonNull
import com.digitalsamurai.hedgehogtest.ui.jokes.PresenterJokesFragment
import com.digitalsamurai.hedgehogtest.ui.web.PresenterWebFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    @NonNull
    fun getPresenterJokes() : PresenterJokesFragment{
        return PresenterJokesFragment()
    }
    @Provides
    @Singleton
    @NonNull
    fun getPresenterWeb() : PresenterWebFragment{
        return PresenterWebFragment()
    }
}