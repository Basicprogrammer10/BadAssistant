package com.connorcode.assistant.app.commands.laketemp

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.http.exceptions.UnirestException
import kotlin.math.roundToInt

class GetLakeTempAction : Action() {
    private val keywords = arrayOf("what", "is", "the", "lake", "current", "temp", "temperature")
    private val weight = intArrayOf(1, 1, 1, 5, 3, 4, 4)
    override fun doCommand(command: String) {
        try {
            // WOO I knew making this api would come in handy :P
            // I made this api, Check the code here https://github.com/Basicprogrammer10/WaterTemp
            // Or the api docs here https://water.connorcode.com/api
            val response = Unirest.get("https://water.connorcode.com/api/temp")
                .header("accept", "application/json")
                .asJson()
                .body
                .getObject()
            val temp = (response.getDouble("temp") * 1000).roundToInt().toFloat() / 1000
            Assistant.getInstance().displayItem(Response("The Lake is currently: $temp°F"))
        } catch (e: UnirestException) {
            Assistant.getInstance()
                .displayItem(Response("Im sorry... I couldn't get the temperature.\nGo make sure the system is up :P"))
        } catch (e: NumberFormatException) {
            Assistant.getInstance()
                .displayItem(Response("Im sorry... I couldn't get the temperature.\nGo make sure the system is up :P"))
        }
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}