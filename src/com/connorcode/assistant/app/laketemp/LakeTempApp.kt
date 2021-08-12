package com.connorcode.assistant.app.laketemp

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.laketemp.GetLakeTempAction

class LakeTempApp : App() {
    override fun getActions(): List<Action> {
        return listOf<Action>(GetLakeTempAction())
    }
}