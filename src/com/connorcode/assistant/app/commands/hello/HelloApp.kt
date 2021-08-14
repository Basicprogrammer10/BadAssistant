package com.connorcode.assistant.app.commands.hello

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class HelloApp : App() {
    override val name = "Hello"
    override val help = "Say Hi :P"
    override val usage = arrayOf("Hello", "How are you")

    override fun getActions(): List<Action> {
        return listOf<Action>(GetHelloAction())
    }
}