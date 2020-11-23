package me.dongheelee.weathersample.presentation.weather

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.dongheelee.celladapter.Cell
import me.dongheelee.celladapter.CellAdapter
import me.dongheelee.celladapter.CouldNotFindCellException
import me.dongheelee.celladapter.StaticCell
import me.dongheelee.weathersample.R
import me.dongheelee.weathersample.databinding.ActivityWeatherBinding
import me.dongheelee.weathersample.databinding.ItemWeatherBinding
import me.dongheelee.weathersample.presentation.weather.adapter.WeatherCellTypes
import me.dongheelee.weathersample.presentation.weather.adapter.WeatherItemCell
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity(), CellAdapter.Delegate<WeatherCellTypes> {

    private lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel by viewModel<WeatherViewModel>()
    private val weatherAdapter = CellAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initRecyclerView()
    }

    override fun cellTypeMapper(viewType: Int, view: View): Cell<WeatherCellTypes> =
        when (viewType) {
            R.layout.item_weather_header -> StaticCell(view)
            R.layout.item_weather -> WeatherItemCell(ItemWeatherBinding.bind(view))
            else -> throw CouldNotFindCellException()
        }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = weatherAdapter
    }

    private fun initViewModel() {
        weatherViewModel.weatherCells.observe(this, weatherAdapter::setCells)
    }
}
