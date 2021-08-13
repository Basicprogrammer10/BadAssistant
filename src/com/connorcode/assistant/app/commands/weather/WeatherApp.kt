package com.connorcode.assistant.app.weather

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.commands.weather.GetWeatherAction

class WeatherApp : App() {
    override val name = "Weather"
    override val help = "Get the weather for a location"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetWeatherAction())
    }
}