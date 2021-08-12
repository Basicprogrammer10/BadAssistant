package com.connorcode.assistant.app.time

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response

class GetTimeAction : Action() {
    private val keywords = arrayOf("what", "is", "the", "time", "current", "epoch")
    private val weight = intArrayOf(1, 1, 1, 5, 4, 6)
    override fun doCommand(command: String) {
        val time = System.currentTimeMillis()
        Assistant.getInstance().displayItem(Response("Current Epoch Time: " + time / 1000))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}