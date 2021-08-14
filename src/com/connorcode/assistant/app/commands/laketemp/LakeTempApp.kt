package com.connorcode.assistant.app.commands.laketemp

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class LakeTempApp : App() {
    override val name = "LakeTemp"
    override val help = "Get the temperature of the lake"
    override val usage = arrayOf("Lake Temp", "whats the current lake temp")

    override fun getActions(): List<Action> {
        return listOf<Action>(GetLakeTempAction())
    }
}