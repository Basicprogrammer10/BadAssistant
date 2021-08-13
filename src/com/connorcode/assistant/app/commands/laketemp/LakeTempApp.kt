package com.connorcode.assistant.app.laketemp

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.laketemp.GetLakeTempAction

class LakeTempApp : App() {
    override val name = "LakeTemp"
    override val help = "Get the temperature of the lake"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetLakeTempAction())
    }
}