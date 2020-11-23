package me.dongheelee.weathersample.di

import me.dongheelee.weathersample.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRepository(get()) }
}
