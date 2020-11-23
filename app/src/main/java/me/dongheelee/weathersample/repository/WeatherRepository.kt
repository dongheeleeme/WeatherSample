package me.dongheelee.weathersample.repository

import android.content.Context
import me.dongheelee.weathersample.R
import me.dongheelee.weathersample.data.RegionWeather
import me.dongheelee.weathersample.data.Weather
import me.dongheelee.weathersample.repository.FetchType.MOCK
import me.dongheelee.weathersample.repository.FetchType.NETWORK
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

enum class FetchType {
    NETWORK, MOCK
}

class WeatherRepository(private val context: Context) {

    fun fetchWeatherData(fetchType: FetchType) =
        getWeatherRows(fetchType)
            .map {
                RegionWeather(
                    regionName = getRegion(it),
                    morningWeather = getWeather(it, Elements::first),
                    afternoonWeather = getWeather(it, Elements::last)
                )
            }

    private fun getWeatherRows(fetchType: FetchType): Elements =
        when (fetchType) {
            NETWORK ->
                Jsoup.connect("https://raw.githubusercontent.com/dongheeleeme/WeatherSample/master/app/src/main/res/raw/weather.html").get()
            MOCK -> {
                val html = context.resources.openRawResource(R.raw.weather).bufferedReader().use { it.readText() }
                Jsoup.parse(html, "utf-8")
            }
        }.select("#container #content table tbody tr")

    private fun getRegion(el: Element): String =
        el.select("th a").text()

    private fun getWeather(el: Element, f: Elements.() -> Element) =
        el.select("td").f().let(::weatherElementParser)

    private fun weatherElementParser(el: Element) =
        el.let {
            Weather(
                iconUrl = it.select("p img").attr("src"),
                status = it.select("ul li.nm").text(),
                temperature = it.select("ul li:not(.nm) .temp").text(),
                chanceOfRain = it.select("ul li:not(.nm) .rain").text()
            )
        }
}
