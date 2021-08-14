package com.connorcode.assistant.app.commands.random

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class RandomApp : App() {
    override val name = "Random"
    override val help = "Generate Random Numbers"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetRandomAction())
    }
}