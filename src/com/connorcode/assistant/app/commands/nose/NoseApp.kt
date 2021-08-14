package com.connorcode.assistant.app.commands.nose

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class NoseApp : App() {
    override val name = "Nose"
    override val help = "Nose You :P"
    override val usage = arrayOf("NOSE", "Shiloh says nose!")

    override fun getActions(): List<Action> {
        return listOf<Action>(GetNoseAction())
    }
}