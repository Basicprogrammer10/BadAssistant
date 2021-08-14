package com.connorcode.assistant.app.commands.{lower_name}

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import kotlin.system.exitProcess

class Get{name}Action : Action() {
    private val keywords = arrayOf()
    private val weight = intArrayOf()
    override fun doCommand(command: String) {
        // Code Here :P
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihoodStrict(command, keywords, weight)
    }
}