package com.connorcode.assistant.app.weather

import java.util.Arrays
import com.mashape.unirest.http.Unirest
import com.connorcode.assistant.app.weather.GetWeatherAction
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.exceptions.UnirestException
import com.connorcode.assistant.Common
import com.connorcode.assistant.Assistant
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import com.mashape.unirest.request.HttpRequest
import org.json.JSONObject

class GetWeatherAction : Action() {
    var keywords = arrayOf("weather", "what", "is", "in")
    var scores = intArrayOf(5, 1, 1, 1)
    override fun doCommand(command: String) {
        // remove keywords from the command to extract the location
        // we want to query the weather for
        val words = listOf(*command.split(" ".toRegex()).toTypedArray())
        var req: HttpRequest? = null
        val location = words[words.size - 1]
        req = if (words.contains("zip") || words.contains("zipcode")) {
            Unirest.get("https://api.openweathermap.org/data/2.5/weather")
                .queryString("zip", location)
                .queryString("appid", API_KEY)
                .queryString("units", "imperial")
        } else {
            Unirest.get("https://api.openweathermap.org/data/2.5/weather")
                .queryString("q", location)
                .queryString("appid", API_KEY)
                .queryString("units", "imperial")
        }
        try {
            val boom = req.asJson()
            val node = boom.body
            handleResult(node)
        } catch (ignored: UnirestException) {
            // IGNORE ERRORS
        }
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, scores)
    }

    companion object {
        // Hmmmmmmm.
        // It's not even my key so...
        private const val API_KEY = "a53af5e648cd61f1249fbe858fd34f71"
        private fun handleResult(node: JsonNode) {
            val assistant = Assistant.getInstance()
            val json = node.getObject()
            val city = json.getString("name")
            val temp = json.optJSONObject("main").getDouble("temp")
            val description = json.optJSONArray("weather").optJSONObject(0).optString("description")
            assistant.displayItem(Response("The temperature in $city is $temp degrees with $description"))
        }
    }
}