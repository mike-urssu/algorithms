package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/14426
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val trieNode = TrieNode()

    val numbers = reader.readLine().split(" ").map { it.toInt() }
    repeat(numbers[0]) {
        val word = reader.readLine()
        trieNode.insert(word)
    }

    var count = 0
    repeat(numbers[1]) {
        val word = reader.readLine()
        if (trieNode.startsWith(word))
            count++
    }

    writer.write("$count")
    writer.flush()
}

class TrieNode(
    private val childNode: MutableMap<Char, TrieNode> = mutableMapOf(),
    private var isEnded: Boolean = false
) {
    fun insert(word: String) {
        var trieNode = this

        for (character in word) {
            trieNode.childNode.putIfAbsent(character, TrieNode())
            trieNode = trieNode.childNode[character]!!
        }

        trieNode.isEnded = true
    }

    fun startsWith(word: String): Boolean {
        var trieNode = this

        for (character in word) {
            if (!trieNode.childNode.containsKey(character))
                return false
            trieNode = trieNode.childNode[character]!!
        }

        return true
    }

    fun contains(word: String): Boolean {
        var trieNode = this

        for (character in word) {
            val childNode = trieNode.childNode[character] ?: return false
            trieNode = childNode
        }

        return trieNode.isEnded
    }
}