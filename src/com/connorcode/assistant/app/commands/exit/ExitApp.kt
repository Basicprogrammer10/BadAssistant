package com.connorcode.assistant.app.commands.exit

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class ExitApp : App() {
    override val name = "Exit"
    override val help = "Go Away :'("

    override fun getActions(): List<Action> {
        return listOf<Action>(GetExitAction())
    }
}