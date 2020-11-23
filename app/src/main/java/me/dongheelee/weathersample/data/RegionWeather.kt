package me.dongheelee.weathersample.data

data class RegionWeather(
    val regionName: String,
    val morningWeather: Weather,
    val afternoonWeather: Weather,
) {

    fun displayRegionName(): String = regionName.split(" ").joinToString("\n")
}
