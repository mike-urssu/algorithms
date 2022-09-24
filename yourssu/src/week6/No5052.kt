package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5052
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    class TrieNode(
        private val childNode: MutableMap<Char, TrieNode> = mutableMapOf(),
        private var isEnded: Boolean = false
    ) {
        fun insert(phoneNumber: String) {
            var trieNode = this

            for (character in phoneNumber) {
                trieNode.childNode.putIfAbsent(character, TrieNode())
                trieNode = trieNode.childNode[character]!!
            }

            trieNode.isEnded = true
        }

        fun isConsistent(phoneNumber: String): Boolean {
            var trieNode = this

            for (character in phoneNumber) {
                if (!trieNode.childNode.containsKey(character))
                    return true
                else if (trieNode.childNode[character]!!.isEnded)
                    return false
                else
                    trieNode = trieNode.childNode[character]!!
            }

            return false
        }
    }

    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val trieNode = TrieNode()
        var isConsistent = true

        val numberOfInput = reader.readLine().toInt()
        repeat(numberOfInput) {
            val phoneNumber = reader.readLine()
            if (!trieNode.isConsistent(phoneNumber))
                isConsistent = false
            trieNode.insert(phoneNumber)
        }

        writer.write("${if (isConsistent) "YES" else "NO"}\n")
    }
    writer.flush()
}