package com.connorcode.assistant.app.commands.time

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetTimeAction : Action() {
    private val keywords = arrayOf("what", "is", "the", "time", "current", "epoch")
    private val weight = intArrayOf(1, 1, 1, 5, 4, 6)
    override fun doCommand(command: String) {
        val epoch = System.currentTimeMillis()
        val normal = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        Assistant.getInstance().displayItem(Response("Current Epoch Time:  ${epoch / 1000}\nCurrent System Time: $normal"))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}