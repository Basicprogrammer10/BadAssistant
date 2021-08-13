package com.connorcode.assistant.app.commands.version

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.Config
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response

class GetVersionAction : Action() {
    private val keywords = arrayOf("what", "is", "the", "version", "github")
    private val weight = intArrayOf(1, 1, 1, 7, 5)
    override fun doCommand(command: String) {
        Assistant.getInstance().displayItem(Response("Made By: Connor Slade\nVersion: ${Config.VERSION}\nGithub: https://github.com/Basicprogrammer10/BadAssistant"))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}