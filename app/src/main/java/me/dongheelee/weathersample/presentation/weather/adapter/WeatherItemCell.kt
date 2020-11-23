package me.dongheelee.weathersample.presentation.weather.adapter

import com.bumptech.glide.Glide
import me.dongheelee.celladapter.Cell
import me.dongheelee.weathersample.data.RegionWeather
import me.dongheelee.weathersample.databinding.ItemWeatherBinding

class WeatherItemCell(private val binding: ItemWeatherBinding) : Cell<WeatherCellTypes>(binding.root) {

    override fun bind(data: WeatherCellTypes) = with(itemView) {
        if (data !is WeatherCellTypes.Item) return

        setWeatherRegion(data.weather)
        setMorningWeather(data.weather)
        setAfternoonWeather(data.weather)
    }

    private fun setWeatherRegion(weather: RegionWeather) {
        binding.textRegion.text = weather.displayRegionName()
    }

    private fun setMorningWeather(weather: RegionWeather) {
        val weatherMorning = binding.weatherMorning
        Glide.with(itemView).load(weather.morningWeather.iconUrl).into(weatherMorning.imageIcon)
        weatherMorning.textStatus.text = weather.morningWeather.status
        weatherMorning.textTemperature.text = weather.morningWeather.temperature
        weatherMorning.textChanceOfRain.text = weather.morningWeather.chanceOfRain
    }

    private fun setAfternoonWeather(weather: RegionWeather) {
        val weatherAfternoon = binding.weatherAfternoon
        Glide.with(itemView).load(weather.morningWeather.iconUrl).into(weatherAfternoon.imageIcon)
        weatherAfternoon.textStatus.text = weather.afternoonWeather.status
        weatherAfternoon.textTemperature.text = weather.afternoonWeather.temperature
        weatherAfternoon.textChanceOfRain.text = weather.afternoonWeather.chanceOfRain
    }
}
