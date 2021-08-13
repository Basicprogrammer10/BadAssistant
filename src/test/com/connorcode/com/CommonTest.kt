@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection")

package test.com.connorcode.com

import com.connorcode.assistant.Common
import org.junit.Test

class CommonTest {
    @Test
    fun testGetLikelihoodStrict() {
        assert(Common.getLikelihoodStrict("hello", arrayOf("hello", "world"), intArrayOf(1, 2)) == 1.0)
        assert(Common.getLikelihoodStrict("world", arrayOf("hello", "world"), intArrayOf(1, 2)) == 2.0)
        assert(Common.getLikelihoodStrict("nose", arrayOf("hello", "world"), intArrayOf(1, 2)) == 0.0)
    }

    @Test
    fun testGetLikelihood() {
        assert(Common.getLikelihood("world", arrayOf("hello", "world"), intArrayOf(1, 2)) == 3.4)
        assert(Common.getLikelihood("worlds", arrayOf("hello", "world"), intArrayOf(1, 2)) == 1.4)
        assert(Common.getLikelihood("qdrfs", arrayOf("hello", "world"), intArrayOf(1, 2)) == 0.0)
    }

    @Test
    fun testDiceCoefficient() {
        assert(Common.diceCoefficient("1", "2") == 0.0)
        assert(Common.diceCoefficient("hello", "hello") == 1.0)
        assert(Common.diceCoefficient("hello", "world") == 0.5)
        assert(Common.diceCoefficient("hello", "helll") == 0.75)
        assert(Common.diceCoefficient("hello", "heello") == 0.8888888888888888)
    }
}