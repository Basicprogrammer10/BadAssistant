package com.connorcode.assistant.app.weather

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.weather.GetWeatherAction

class WeatherApp : App() {
    override fun getActions(): List<Action> {
        return listOf<Action>(GetWeatherAction())
    }
}