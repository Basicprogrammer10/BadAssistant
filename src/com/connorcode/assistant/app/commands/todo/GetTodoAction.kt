package com.connorcode.assistant.app.commands.todo

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import kotlin.system.exitProcess

class GetTodoAction : Action() {
    private val keywords = arrayOf("todo", "add", "complete", "done", "finished")
    private val weight = intArrayOf(7, 2, 2, 1, 2)
    override fun doCommand(command: String) {
        println("To Do...")
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihoodStrict(command, keywords, weight)
    }
}