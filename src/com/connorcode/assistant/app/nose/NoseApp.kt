package com.connorcode.assistant.app.nose

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.nose.GetNoseAction

class NoseApp : App() {
    override fun getActions(): List<Action> {
        return listOf<Action>(GetNoseAction())
    }
}