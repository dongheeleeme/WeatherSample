package me.dongheelee.weathersample.di

import me.dongheelee.weathersample.presentation.weather.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
}
