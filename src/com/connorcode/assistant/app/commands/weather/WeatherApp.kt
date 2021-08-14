package com.connorcode.assistant.app.commands.weather

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class WeatherApp : App() {
    override val name = "Weather"
    override val help = "Get the weather for a location"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetWeatherAction())
    }
}