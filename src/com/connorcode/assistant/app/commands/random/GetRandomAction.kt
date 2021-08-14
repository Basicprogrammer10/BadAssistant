package com.connorcode.assistant.app.commands.random

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import kotlin.random.Random

class GetRandomAction : Action() {
    private val keywords = arrayOf("random", "number", "min", "max")
    private val weight = intArrayOf(6, 4, 3, 3)
    override fun doCommand(command: String) {
        val splitCommand = command.split(" ")
        var min = 0
        var max = 100

        for (j in arrayOf("min", "max")) {
            for (i in splitCommand.indices) {
                if (Common.diceCoefficient(splitCommand[i], j) >= 0.9) {
                    if (j == "min") min = splitCommand[i + 1].toInt()
                    if (j == "max") max = splitCommand[i + 1].toInt()
                }
            }
        }

        val random = Random.nextInt(min, max)
        Assistant.getInstance().displayItem(Response("From $min - $max\n$random"))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}