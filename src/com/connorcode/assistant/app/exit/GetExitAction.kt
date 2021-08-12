package com.connorcode.assistant.app.exit

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import kotlin.system.exitProcess

class GetExitAction : Action() {
    private val keywords = arrayOf("go", "away", "exit", "bye", "goodbye")
    private val weight = intArrayOf(2, 3, 6, 5, 6)
    override fun doCommand(command: String) {
        Assistant.getInstance().displayItem(Response("Ok... :/"))
        exitProcess(0)
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihoodStrict(command, keywords, weight)
    }
}