package com.connorcode.assistant.app.commands.hello

import com.connorcode.assistant.Assistant
import com.connorcode.assistant.Common
import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.Response
import java.util.*

// Define Responses
private val RESPONSE = arrayOf(
    "Im Good :P",
    "I am doing well.. Thanks for asking",
    "Not bad",
    "Could be bettor...",
    "✨",
    "╰(*°▽°*)╯",
    "Amazing!",
    "A bit slow...",
    "According to my lawyer I don’t have to answer that question",
    "I can’t complain. My contract actually forbids me",
    "Ready for a nap",
    "I hear good things. But I don’t think it’s smart to believe rumors",
    "Hey, how are you?",
    "How am I doing WHAT?",
    "I dunno. Is it almost the weekend?",
    "It’s a secret",
    "Pass. Next question, please",
    "Oh terrible, but I’m used to it"
)

class GetHelloAction : Action() {
    private val keywords = arrayOf("hello", "how", "are", "you", "today")
    private val weight = intArrayOf(5, 2, 2, 3, 2)

    override fun doCommand(command: String) {
        Assistant.getInstance().displayItem(Response(RESPONSE[Random().nextInt(RESPONSE.size)]))
    }

    override fun getLikelihood(command: String): Double {
        return Common.getLikelihood(command, keywords, weight)
    }
}