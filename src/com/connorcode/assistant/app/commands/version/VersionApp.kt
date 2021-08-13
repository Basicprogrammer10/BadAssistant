package com.connorcode.assistant.app.commands.version

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class VersionApp : App() {
    override fun getActions(): List<Action> {
        return listOf<Action>(GetVersionAction())
    }
}