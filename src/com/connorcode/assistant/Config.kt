package com.connorcode.assistant

import com.connorcode.assistant.app.App
import com.connorcode.assistant.app.commands.coinflip.CoinFlipApp
import com.connorcode.assistant.app.commands.version.VersionApp
import com.connorcode.assistant.app.commands.exit.ExitApp
import com.connorcode.assistant.app.commands.hello.HelloApp
import com.connorcode.assistant.app.commands.help.HelpApp
import com.connorcode.assistant.app.commands.laketemp.LakeTempApp
import com.connorcode.assistant.app.commands.nose.NoseApp
import com.connorcode.assistant.app.commands.random.RandomApp
import com.connorcode.assistant.app.commands.time.TimeApp
import com.connorcode.assistant.app.commands.weather.WeatherApp

/// Some config options
object Config {
    // Resort to Chat Bot if command not found
    const val CHAT_BOT = false

    // App Version
    const val VERSION = "V0.0α"

    // Font Settings
    // MonoSpace Fonts work best :P
    const val FONT = "JetBrains Mono"
    const val FONT_SIZE = 13

    // Commands to load
    @JvmStatic
    val COMMANDS: Array<App> = arrayOf(
            NoseApp(),
            ExitApp(),
            HelloApp(),
            LakeTempApp(),
            TimeApp(),
            VersionApp(),
            WeatherApp(),
            HelpApp(),
            CoinFlipApp(),
            RandomApp()
    )
}