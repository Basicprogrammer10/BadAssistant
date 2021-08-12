package com.connorcode.assistant.app

abstract class Action {
    // performs action on the input command
    abstract fun doCommand(command: String)

    // returns the likelihood score that the input command should be
    // handled by this AppAction
    abstract fun getLikelihood(command: String): Double
}