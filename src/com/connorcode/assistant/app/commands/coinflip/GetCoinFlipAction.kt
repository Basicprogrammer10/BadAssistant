package com.connorcode.assistant.app.commands.coinflip

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import kotlin.random.Random


class GetCoinFlipAction : Action() {
    private val keywords = arrayOf("flip", "a", "coin")
    private val weight = intArrayOf(4, 1, 5)
    override fun doCommand(command: String) {
        var response = "Heads!"
        if (Random.nextBoolean()) response = "Tails!"
        Assistant.getInstance().displayItem(Response(response))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihoodStrict(command, keywords, weight)
    }
}