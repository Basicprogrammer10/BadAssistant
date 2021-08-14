package com.connorcode.assistant.app.commands.{lower_name}

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class {name}App : App() {
    override val name = "{name}"
    override val help = ""

    override fun getActions(): List<Action> {
        return listOf<Action>(Get{name}Action())
    }
}