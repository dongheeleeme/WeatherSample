package me.dongheelee.weathersample.domain

import me.dongheelee.weathersample.data.RegionWeather
import me.dongheelee.weathersample.repository.FetchType.NETWORK
import me.dongheelee.weathersample.repository.WeatherRepository

class GetNaverWeathersUseCase(
    private val weatherRepository: WeatherRepository,
) {
    fun execute(): List<RegionWeather> = weatherRepository.fetchWeatherData(NETWORK)
}
