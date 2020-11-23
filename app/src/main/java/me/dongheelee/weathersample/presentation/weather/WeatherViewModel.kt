package me.dongheelee.weathersample.presentation.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.dongheelee.celladapter.plus
import me.dongheelee.weathersample.domain.GetNaverWeathersUseCase
import me.dongheelee.weathersample.presentation.weather.adapter.WeatherCellTypes
import kotlin.concurrent.thread

class WeatherViewModel(
    private val getNaverWeathersUseCase: GetNaverWeathersUseCase,
) : ViewModel() {

    private val _weatherCells = MutableLiveData<List<WeatherCellTypes>>()
    val weatherCells: LiveData<List<WeatherCellTypes>> = _weatherCells

    init {
        getWeatherCells()
    }

    private fun getWeatherCells() {
        thread {
            val cells = WeatherCellTypes.Header + getNaverWeathersUseCase.execute().map(WeatherCellTypes::Item)
            _weatherCells.postValue(cells)
        }
    }
}
