package com.connorcode.assistant.app.help

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.nose.GetNoseAction

class HelpApp : App() {
    override val name = "Help"
    override val help = "Get Info about commands"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetHelpAction())
    }
}