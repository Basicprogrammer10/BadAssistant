package com.connorcode.assistant

import java.util.HashMap

object Common {
    fun getLikelihood(rawCommand: String, keywords: Array<String>, weight: IntArray): Double {
        var score = 0.0
        val commands = rawCommand.split(" ".toRegex()).toTypedArray()
        for (command in commands) {
            for (k in keywords.indices) {
                val keyword = keywords[k]
                if (command == keyword) score += weight[k]
                if (diceCoefficient(command, keyword) >= 0.7) score += weight[k] * 0.7
            }
        }
        return score
    }

    fun getLikelihoodStrict(rawCommand: String, keywords: Array<String>, weight: IntArray): Double {
        var score = 0.0
        for (k in keywords.indices) {
            val keyword = keywords[k]
            if (rawCommand.contains(keyword)) score += weight[k]
        }
        return score
    }

    // This took too much time to make...
    // At least its kinda cool
    private fun diceCoefficient(rawA: String, rawB: String): Double {
        // Remove Spaces

        val a = rawA.replace(" ", "")
        val b = rawB.replace(" ", "")

        // Check some simple cases
        if (a == b) return 1.0
        if (a.length < 2 || b.length < 2) return 0.0
        val firstBigrams = HashMap<String, Int>()
        for (i in a.indices) {
            val bigram = a.substring(i, i + 1)
            val count = firstBigrams.getOrDefault(bigram, 1)
            firstBigrams[bigram] = count
        }
        var intersectionSize = 0
        for (i in b.indices) {
            val bigram = b.substring(i, i + 1)
            val count = firstBigrams.getOrDefault(bigram, 0)
            if (count <= 0) continue
            firstBigrams[bigram] = count - 1
            intersectionSize++
        }
        return 2.0 * intersectionSize / (a.length + b.length - 2)
    }
}