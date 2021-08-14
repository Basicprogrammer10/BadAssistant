package com.connorcode.assistant.app.commands.help

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.Config
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.Response

class GetHelpAction : Action() {
    private val keywords = arrayOf("help", "i", "need")
    private val weight = intArrayOf(8, 1, 1)
    override fun doCommand(command: String) {
        val commands = command.split(" ")
        val apps = Config.COMMANDS

        if (commands.size == 1) mainHelp(apps)
        if (commands.size >= 2) commandHelp(apps, commands)
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}

fun mainHelp(apps: Array<App>) {
    val longName = getLongestName(apps) + 1
    var helpString = ""
    for (i in apps) {
        val padding = longName - i.name.length
        helpString += "${i.name}${" ".repeat(padding)}- ${i.help}\n"
    }
    Assistant.getInstance().displayItem(Response(helpString))
}

fun commandHelp(apps: Array<App>, commands: List<String>) {
    val command = commands[1]
    for (i in apps) {
        if (Common.diceCoefficient(i.name.lowercase(), command) < 0.8) continue
        var examples = ""
        for (j in i.usage) {
            examples += "  • ${Common.TitleCase(j)}\n"
        }
        examples = examples.substring(0..examples.length-2)
        Assistant.getInstance().displayItem(Response("${i.name} - ${i.help}\n\nExamples:\n$examples"))
        return
    }
    Assistant.getInstance().displayItem(Response("Sorry no help page was found for that command..."))
}

fun getLongestName(apps: Array<App>): Int {
    var len = Int.MIN_VALUE
    for (i in apps) {
        if (i.name.length > len) len = i.name.length
    }
    return len
}