package com.connorcode.assistant.app

// an App is a collections of related features supported by
// the Virtual Assistant
// Known Apps: Time app, Weather App, Reminders App, Spotify App,
abstract class App {
    abstract val name: String
    abstract val help: String
    // gets a list of actions associated with this app
    abstract fun getActions(): List<Action>
}