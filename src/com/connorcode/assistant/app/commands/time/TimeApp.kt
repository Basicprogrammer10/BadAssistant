package com.connorcode.assistant.app.commands.time

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class TimeApp : App() {
    override val name = "Time"
    override val help = "Get current Epoch Time"
    override val usage = arrayOf("Whats the time", "Current time", "Epoch Time")

    override fun getActions(): List<Action> {
        return listOf<Action>(GetTimeAction())
    }
}