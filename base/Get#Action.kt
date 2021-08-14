package com.connorcode.assistant.app.commands.{lower_name}

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response

class Get{name}Action : Action() {
    private val keywords = arrayOf()
    private val weight = intArrayOf()
    override fun doCommand(command: String) {
        // Code Here :P
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}