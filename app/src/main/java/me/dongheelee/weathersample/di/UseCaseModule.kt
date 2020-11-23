package me.dongheelee.weathersample.di

import me.dongheelee.weathersample.domain.GetNaverWeathersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetNaverWeathersUseCase(get()) }
}
