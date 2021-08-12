package com.connorcode.assistant.app.nose

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response

class GetNoseAction : Action() {
    private val keywords = arrayOf("nose", "dog", "shiloh")
    private val weight = intArrayOf(5, 5, 6)
    override fun doCommand(command: String) {
        Assistant.getInstance().displayItem(Response("^..^      /\n/_/\\_____/\n   /\\   /\\\n  /  \\ /  \\"))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}