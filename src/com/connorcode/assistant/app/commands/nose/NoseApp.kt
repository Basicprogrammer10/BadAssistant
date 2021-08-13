package com.connorcode.assistant.app.nose

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.nose.GetNoseAction

class NoseApp : App() {
    override val name = "Nose"
    override val help = "Nose You :P"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetNoseAction())
    }
}