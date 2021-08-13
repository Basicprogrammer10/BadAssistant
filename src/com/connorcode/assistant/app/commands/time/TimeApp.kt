package com.connorcode.assistant.app.time

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.time.GetTimeAction

class TimeApp : App() {
    override val name = "Time"
    override val help = "Get current Epoch Time"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetTimeAction())
    }
}