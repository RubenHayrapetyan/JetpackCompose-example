package com.domovedov.ru.app

import com.domovedov.ru.ui.home.stories.StoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StoriesViewModel(get()) }
 //   viewModel { StoriesViewModel() }
}