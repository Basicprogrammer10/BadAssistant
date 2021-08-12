package com.connorcode.assistant.app.exit

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.exit.GetExitAction

class ExitApp : App() {
    override fun getActions(): List<Action> {
        return listOf<Action>(GetExitAction())
    }
}