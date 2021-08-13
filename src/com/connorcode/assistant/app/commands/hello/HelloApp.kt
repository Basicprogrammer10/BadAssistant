package com.connorcode.assistant.app.hello

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.hello.GetHelloAction

class HelloApp : App() {
    override val name = "Hello"
    override val help = "Say Hi :P"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetHelloAction())
    }
}