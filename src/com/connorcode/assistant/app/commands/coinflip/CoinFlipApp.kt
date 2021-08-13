package com.connorcode.assistant.app.commands.coinflip

import com.connorcode.assistant.app.Action
import com.connorcode.assistant.app.App

class CoinFlipApp : App() {
    override val name = "Coin Flip"
    override val help = "Flip a Coin!"

    override fun getActions(): List<Action> {
        return listOf<Action>(GetCoinFlipAction())
    }
}