package com.connorcode.assistant.app.help

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.Config
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.Response

class GetHelpAction : Action() {
    private val keywords = arrayOf("help", "i", "need")
    private val weight = intArrayOf(7, 1, 1)
    override fun doCommand(command: String) {
        val longName = getLongestName(Config.COMMANDS) + 1
        var helpString = ""
        for (i in Config.COMMANDS) {
            val padding = longName - i.name.length
            helpString += "${i.name}${" ".repeat(padding)}- ${i.help}\n"
        }
        println(helpString)
        Assistant.getInstance().displayItem(Response(helpString))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}

fun getLongestName(apps: Array<App>): Int {
    var len = Int.MIN_VALUE;
    for (i in apps) {
        if (i.name.length > len) len = i.name.length
    }
    return len
}