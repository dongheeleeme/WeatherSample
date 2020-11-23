package me.dongheelee.weathersample.presentation.weather.adapter

import me.dongheelee.celladapter.CellType
import me.dongheelee.weathersample.R
import me.dongheelee.weathersample.data.RegionWeather

sealed class WeatherCellTypes : CellType {

    object Header : WeatherCellTypes() {
        override fun uniqueId(): String = "Header"
        override fun layoutId(): Int = R.layout.item_weather_header
    }

    data class Item(val weather: RegionWeather) : WeatherCellTypes() {
        override fun uniqueId(): String = "Item_${hashCode()}"
        override fun layoutId(): Int = R.layout.item_weather
    }
}
