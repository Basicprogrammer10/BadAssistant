package com.connorcode.assistant.app.commands.todo

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class TodoApp : App() {
    override val name = "Todo"
    override val help = "Keep track of what you need to do"
    override val usage = arrayOf("WIP")

    override fun getActions(): List<Action> {
        return listOf<Action>(GetTodoAction())
    }
}